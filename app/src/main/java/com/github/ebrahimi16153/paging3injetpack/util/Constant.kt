package com.github.ebrahimi16153.paging3injetpack.util

import com.github.ebrahimi16153.paging3injetpack.BuildConfig

object Constant {

    const val TIMEOUT = 120L
    const val BASE_URL = "https://api.unsplash.com/"

    const val UN_SPLASH_IMAGE_TABLE = "un_splash_image_table"
    const val UN_SPLASH_DATABASE = "un_splash_image_database"
    const val UN_SPLASH_REMOTE_KEY_TABLE = "un_splash_remote_key_table"

    const val API_KEY = BuildConfig.API_KEY
    const val ITEMS_PER_PAGE = 10

}