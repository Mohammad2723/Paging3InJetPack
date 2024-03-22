package com.github.ebrahimi16153.paging3injetpack.di

import android.content.Context
import androidx.compose.ui.unit.Constraints
import androidx.room.Room
import com.github.ebrahimi16153.paging3injetpack.db.UnsplashDataBase
import com.github.ebrahimi16153.paging3injetpack.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UnsplashDataBase::class.java, Constant.UN_SPLASH_DATABASE)
            .build()


}