package com.dhananjay.userfeedapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dhananjay.userfeedapp.data.remote.Author
import com.dhananjay.userfeedapp.data.remote.Media

@Entity
data class UserFeedEntity(
    @PrimaryKey val id: Int,
    val authorName: String,
    val authorImage: String,
    val comments: Int,
    val content: String,
    val likes: Int,
    val mediaType: String,
    val mediaUrl: String,
    val postTime: String,
    val postType: String
)
