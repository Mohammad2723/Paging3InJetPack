package com.github.ebrahimi16153.paging3injetpack.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.github.ebrahimi16153.paging3injetpack.api.ApiService
import com.github.ebrahimi16153.paging3injetpack.db.UnsplashDataBase
import com.github.ebrahimi16153.paging3injetpack.models.remot.UnsplashRemoteKey
import com.github.ebrahimi16153.paging3injetpack.models.unsplashimage.UnsplashImage
import com.github.ebrahimi16153.paging3injetpack.util.Constant.ITEMS_PER_PAGE
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class UnsplashRemoteMediator @Inject constructor(
    private val apiService: ApiService,
    private val unsplashDataBase: UnsplashDataBase
) : RemoteMediator<Int, UnsplashImage>() {

    private val unsplashRemoteKeysDao = unsplashDataBase.unsplashRemoteKeyDao
    private val unsplashImageDao = unsplashDataBase.unsplashImageDao

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UnsplashImage>
    ): MediatorResult {
        return try {
             val currentPage = when(loadType){
                 LoadType.REFRESH -> {
                     val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                     remoteKeys?.nextPage?.minus(1) ?: 1
                 }
                 LoadType.PREPEND -> {
                     val remoteKeys = getRemoteKeyForFirstItem(state)
                     val prevPage = remoteKeys?.prevPage
                         ?: return MediatorResult.Success(
                             endOfPaginationReached = remoteKeys != null
                         )
                     prevPage
                 }
                 LoadType.APPEND -> {
                     val remoteKeys = getRemoteKeyForLastItem(state)
                     val nextPage = remoteKeys?.nextPage
                         ?: return MediatorResult.Success(
                             endOfPaginationReached = remoteKeys != null
                         )
                     nextPage
                 }
             }

            val response = apiService.getAllImages(page = currentPage, prePage = ITEMS_PER_PAGE)
            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            unsplashDataBase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    unsplashImageDao.deleteAllImages()
                    unsplashRemoteKeysDao.deleteRemoteKeys()
                }
                val keys = response.map { unsplashImage ->
                    UnsplashRemoteKey(
                        id = unsplashImage.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                unsplashRemoteKeysDao.addAllRemoteKeys(remoteKeys = keys)
                unsplashImageDao.addImages(images = response)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)

        } catch (e: Exception) {

            MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, UnsplashImage>
    ): UnsplashRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                unsplashRemoteKeysDao.getRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, UnsplashImage>
    ): UnsplashRemoteKey? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { unsplashImage ->
                unsplashRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, UnsplashImage>
    ): UnsplashRemoteKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { unsplashImage ->
                unsplashRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
            }


    }
}