package com.dhananjay.userfeedapp.data.mappers

import com.dhananjay.userfeedapp.data.models.UserFeedEntity
import com.dhananjay.userfeedapp.data.remote.Author
import com.dhananjay.userfeedapp.data.remote.Media
import com.dhananjay.userfeedapp.data.remote.UserFeedDemoDataItem
import com.dhananjay.userfeedapp.data.remote.UserFeedDto
import com.dhananjay.userfeedapp.domain.AuthorData
import com.dhananjay.userfeedapp.domain.MediaData
import com.dhananjay.userfeedapp.domain.UserFeed

fun UserFeedDemoDataItem.toUserFeedEntity(): UserFeedEntity {
    return UserFeedEntity(
        id = id,
        authorName = author.name,
        authorImage = author.image,
        comments = comments,
        content = content,
        likes = likes,
        mediaType =  media.type,
        mediaUrl = media.url,
        postTime = postTime,
        postType = postType
    )
}

fun UserFeedEntity.toUserFeed(): UserFeed {
    return UserFeed(
        id = id,
        author = AuthorData(authorImage, authorName),
        comments = comments,
        content = content,
        likes = likes,
        media = MediaData(mediaType, mediaUrl),
        postTime = postTime,
        postType = postType
    )
}