package com.github.ebrahimi16153.paging3injetpack.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.ebrahimi16153.paging3injetpack.models.remot.UnsplashRemoteKey
import com.github.ebrahimi16153.paging3injetpack.models.unsplashimage.UnsplashImage


@Database(entities = [UnsplashImage::class , UnsplashRemoteKey::class], version = 1)
abstract class UnsplashDataBase:RoomDatabase() {
    abstract val unsplashImageDao:UnsplashImageDao
    abstract val unsplashRemoteKeyDao:UnsplashRemoteKeysDao
}