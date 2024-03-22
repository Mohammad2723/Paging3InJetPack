package com.github.ebrahimi16153.paging3injetpack.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.ebrahimi16153.paging3injetpack.models.unsplashimage.UnsplashImage
import com.github.ebrahimi16153.paging3injetpack.util.Constant


@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM ${Constant.UN_SPLASH_IMAGE_TABLE}")
    suspend fun getAllImages():PagingSource<Int,UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images:List<UnsplashImage>)

    @Query("DELETE FROM ${Constant.UN_SPLASH_IMAGE_TABLE}")
    suspend fun deleteAllImages()

}