package com.github.ebrahimi16153.paging3injetpack.models.unsplashimage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Urls(
 @SerialName("regular")
 val regularImage:String
)

