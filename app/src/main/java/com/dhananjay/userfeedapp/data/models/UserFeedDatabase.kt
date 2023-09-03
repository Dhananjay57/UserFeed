package com.dhananjay.userfeedapp.data.models

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [UserFeedEntity::class],
    version = 1
)
abstract class UserFeedDatabase : RoomDatabase() {
    abstract val dao : UserFeedDao
}