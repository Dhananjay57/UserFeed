package com.dhananjay.userfeedapp.data.models

data class FeedPost(
    val author: Author,
    val comments: Int,
    val content: String,
    val likes: Int,
    val media: Media,
    val postTime: String,
    val postType: String
)