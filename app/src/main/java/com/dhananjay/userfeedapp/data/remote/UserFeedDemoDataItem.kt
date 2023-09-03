package com.dhananjay.userfeedapp.data.remote

data class UserFeedDemoDataItem(
    val author: Author,
    val comments: Int,
    val content: String,
    val id: Int,
    val likes: Int,
    val media: Media,
    val postTime: String,
    val postType: String
)