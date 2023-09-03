package com.dhananjay.userfeedapp.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.dhananjay.userfeedapp.domain.UserFeed

@Composable
fun UserFeedScreen(users: LazyPagingItems<UserFeed>) {
    val context = LocalContext.current

    LaunchedEffect(key1 = users.loadState) {
        if (users.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error ${(users.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (users.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(1.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(users.itemCount) { index ->
                    if (users.itemCount != null) {
                        FeedItem(
                            users = users[index]!!,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                item {
                    if (users.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}