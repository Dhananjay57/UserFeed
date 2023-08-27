package com.dhananjay.userfeedapp.data.remote

import com.dhananjay.userfeedapp.data.models.UserFeedData
import retrofit2.http.GET
import retrofit2.http.Query

interface UserFeedApi {
    @GET("d53fe614-6842-4458-8b8b-d7d323567862")
    suspend fun getUserFeed(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ): List<UserFeedData>

    companion object {
        const val BASE_URL = "https://mocki.io/v1/"
    }
}