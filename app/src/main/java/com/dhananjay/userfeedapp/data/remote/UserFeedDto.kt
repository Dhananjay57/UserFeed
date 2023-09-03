package com.dhananjay.userfeedapp.data.remote

data class UserFeedDto(
    val id : Int,
    val author: Author,
    val comments: Int,
    val content: String,
    val likes: Int,
    val media: Media,
    val postTime: String,
    val postType: String
)
