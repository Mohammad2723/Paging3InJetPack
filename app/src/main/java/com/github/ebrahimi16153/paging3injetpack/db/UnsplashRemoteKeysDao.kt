package com.github.ebrahimi16153.paging3injetpack.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.ebrahimi16153.paging3injetpack.models.remot.UnsplashRemoteKey
import com.github.ebrahimi16153.paging3injetpack.util.Constant


@Dao
interface UnsplashRemoteKeysDao {

    @Query("SELECT * FROM ${Constant.UN_SPLASH_REMOTE_KEY_TABLE} WHERE id =:id")
    suspend fun getRemoteKeys(id:String): UnsplashRemoteKey

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys:List<UnsplashRemoteKey>)

    @Query("DELETE FROM ${Constant.UN_SPLASH_REMOTE_KEY_TABLE}")
    suspend fun deleteRemoteKeys()

}