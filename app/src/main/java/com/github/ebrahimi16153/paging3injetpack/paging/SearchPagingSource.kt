package com.github.ebrahimi16153.paging3injetpack.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.ebrahimi16153.paging3injetpack.api.ApiService
import com.github.ebrahimi16153.paging3injetpack.models.SearchResult
import com.github.ebrahimi16153.paging3injetpack.models.unsplashimage.UnsplashImage

class SearchPagingSource(
    private val apiService: ApiService,
    private val query: String
) : PagingSource<Int, UnsplashImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        val currentPage = params.key ?: 1
        return try {
            val response: SearchResult = apiService.searchImages(query = query, page = currentPage)

            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey =  currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return null
    }

}