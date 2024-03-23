package com.github.ebrahimi16153.paging3injetpack.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.ebrahimi16153.paging3injetpack.api.ApiService
import com.github.ebrahimi16153.paging3injetpack.db.UnsplashDataBase
import com.github.ebrahimi16153.paging3injetpack.models.unsplashimage.UnsplashImage
import com.github.ebrahimi16153.paging3injetpack.paging.UnsplashRemoteMediator
import com.github.ebrahimi16153.paging3injetpack.util.Constant.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService,
    private val dataBase: UnsplashDataBase
) {
    @OptIn(ExperimentalPagingApi::class)
    fun getAllImages():Flow<PagingData<UnsplashImage>>{
        val pagingSourceFactory = { dataBase.unsplashImageDao.getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                apiService = apiService,
                unsplashDataBase = dataBase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }


}