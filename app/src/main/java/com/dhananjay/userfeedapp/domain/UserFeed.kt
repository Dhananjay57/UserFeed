package com.dhananjay.userfeedapp.domain


data class UserFeed(
    val id: Int,
    val author: AuthorData,
    val comments: Int,
    val content: String,
    val likes: Int,
    val media: MediaData,
    val postTime: String,
    val postType: String
)

data class AuthorData(
    val image: String,
    val name: String
)

data class MediaData(
    val type: String,
    val url: String
)
