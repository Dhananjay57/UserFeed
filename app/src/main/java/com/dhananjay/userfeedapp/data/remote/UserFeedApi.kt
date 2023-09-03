package com.dhananjay.userfeedapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface UserFeedApi {
    @GET(END_POINT)
    suspend fun getUserFeed(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ): UserFeedDemoDto

    companion object {
        const val BASE_URL = "https://mocki.io/v1/"
        const val END_POINT = "38275dc7-2ee1-4fa7-b69f-a36c56106081"
    }
}