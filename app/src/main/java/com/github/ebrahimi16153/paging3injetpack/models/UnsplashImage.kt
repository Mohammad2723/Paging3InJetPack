package com.github.ebrahimi16153.paging3injetpack.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.ebrahimi16153.paging3injetpack.util.Constant


@Entity(tableName = Constant.UN_SPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    @Embedded
    val urls:Urls,
    val likeLInt: Int,
    @Embedded
    val user:User
)
