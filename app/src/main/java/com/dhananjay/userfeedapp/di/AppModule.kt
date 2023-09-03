package com.dhananjay.userfeedapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dhananjay.userfeedapp.data.models.UserFeedDatabase
import com.dhananjay.userfeedapp.data.models.UserFeedEntity
import com.dhananjay.userfeedapp.data.remote.UserFeedApi
import com.dhananjay.userfeedapp.data.remote.UserFeedRemoteMediator
import com.dhananjay.userfeedapp.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserFeedDataBase(@ApplicationContext context: Context): UserFeedDatabase {
        return Room.databaseBuilder(
            context,
            UserFeedDatabase::class.java,
            "userfeed.db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideUserFeedApi(): UserFeedApi {
        return Retrofit.Builder()
            .baseUrl(UserFeedApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideUserFeedPager(
        userFeedDb: UserFeedDatabase,
        userFeedApi: UserFeedApi
    ): Pager<Int, UserFeedEntity> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = UserFeedRemoteMediator(
                userFeedDb = userFeedDb,
                userFeedApi = userFeedApi
            ),
            pagingSourceFactory = {
                userFeedDb.dao.pagingSource()
            }
        )
    }

}