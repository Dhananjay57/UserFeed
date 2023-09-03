package com.dhananjay.userfeedapp.data.models

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
@Dao
interface  UserFeedDao {
    @Upsert
    suspend fun upsertAll(useFeed: List<UserFeedEntity>)
    @Query("SELECT * FROM userfeedentity")
    fun pagingSource(): PagingSource<Int, UserFeedEntity>
    @Query("DELETE FROM userfeedentity")
    suspend fun clearAll()
}