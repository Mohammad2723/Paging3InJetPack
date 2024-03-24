package com.github.ebrahimi16153.paging3injetpack.api

import com.github.ebrahimi16153.paging3injetpack.models.SearchResult
import com.github.ebrahimi16153.paging3injetpack.models.unsplashimage.UnsplashImage
import com.github.ebrahimi16153.paging3injetpack.util.Constant
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Authorization: ${Constant.API_KEY}")
    @GET("photos")
    suspend fun getAllImages(@Query("page") page:Int, @Query("pre_page") prePage:Int)
    :List<UnsplashImage>


    @Headers("Authorization: Client-ID ${Constant.API_KEY}")
    @GET("search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): SearchResult
}