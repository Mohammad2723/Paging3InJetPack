package com.github.ebrahimi16153.paging3injetpack.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.ebrahimi16153.paging3injetpack.util.Constant.UN_SPLASH_REMOTE_KEY_TABLE

@Entity(tableName = UN_SPLASH_REMOTE_KEY_TABLE)
data class UnsplashRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val prevPage:Int?,
    val nextPage:Int?
)