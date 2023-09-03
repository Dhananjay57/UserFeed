package com.dhananjay.userfeedapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dhananjay.mycompose.ui.theme.MycomposeTheme
import com.dhananjay.userfeedapp.domain.AuthorData
import com.dhananjay.userfeedapp.domain.MediaData
import com.dhananjay.userfeedapp.domain.UserFeed

@Composable
fun FeedItem(
    users: UserFeed,
    modifier: Modifier = Modifier
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = "https://fastly.picsum.photos/id/9/5000/3269.jpg?hmac=cZKbaLeduq7rNB8X-bigYO8bvPIWtT-mh8GRXtU3vPc",
                //users.author.image,
                contentDescription = users.author.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = users.author.name,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = users.postTime,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = users.postType,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    Spacer(modifier = Modifier.width(8.dp))
    Column(
        modifier = Modifier
            .fillMaxHeight().padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = users.content,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = "https://fastly.picsum.photos/id/9/5000/3269.jpg?hmac=cZKbaLeduq7rNB8X-bigYO8bvPIWtT-mh8GRXtU3vPc",
            contentDescription = "Questions",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth().height(150.dp)
                .clip(RectangleShape)
                .border(1.dp, Color.Gray, RectangleShape),
            alignment = Alignment.Center
        )
    }
    Spacer(modifier = Modifier.width(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Like Icon and Text
        Icon(
            imageVector = Icons.Default.ThumbUp,
            contentDescription = null,
            tint = Color.Blue, // Customize the color
            modifier = Modifier
                .padding(end = 4.dp)
        )
        Text(
            text = "${users.likes } Like",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.weight(1f))

        // Comment Icon and Text
        Icon(
            imageVector = Icons.Default.Create,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 4.dp)
        )
        Text(
            text = "${users.comments } Comment",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.weight(1f))

        // Share Icon and Text
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 4.dp)
        )
        Text(
            text = "Share",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun FeedItemPreview() {
    MycomposeTheme {
        FeedItem(
            users = UserFeed(
                id = 1,
                author = AuthorData("https://fastly.picsum.photos/id/9/5000/3269.jpg?hmac=cZKbaLeduq7rNB8X-bigYO8bvPIWtT-mh8GRXtU3vPc", "John"),
                comments = 1,
                content = "k",
                likes = 2,
                media = MediaData("", "https://fastly.picsum.photos/id/9/5000/3269.jpg?hmac=cZKbaLeduq7rNB8X-bigYO8bvPIWtT-mh8GRXtU3vPc"),
                postTime = "String",
                postType = "String"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

