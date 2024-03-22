package com.github.ebrahimi16153.paging3injetpack.models.unsplashimage

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("links")
    @Embedded
    val userLink: UserLinks,
    val username:String
)
