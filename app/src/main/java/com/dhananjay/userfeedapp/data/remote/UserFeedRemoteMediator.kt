package com.dhananjay.userfeedapp.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.dhananjay.userfeedapp.data.models.UserFeedDatabase
import com.dhananjay.userfeedapp.data.models.UserFeedEntity
import com.dhananjay.userfeedapp.data.mappers.toUserFeedEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class UserFeedRemoteMediator(
    private val userFeedDb: UserFeedDatabase,
    private val userFeedApi: UserFeedApi
) : RemoteMediator<Int, UserFeedEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserFeedEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val userFeed = userFeedApi.getUserFeed(
                page = loadKey,
                pageCount = state.config.pageSize
            )

            userFeedDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    userFeedDb.dao.clearAll()
                }
                val userFeedEntities = userFeed.map { it.toUserFeedEntity() }
                userFeedDb.dao.upsertAll(userFeedEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = userFeed.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}