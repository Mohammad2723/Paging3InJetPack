package com.github.ebrahimi16153.paging3injetpack.models

import com.github.ebrahimi16153.paging3injetpack.models.unsplashimage.UnsplashImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("results")
    val images: List<UnsplashImage>,
)