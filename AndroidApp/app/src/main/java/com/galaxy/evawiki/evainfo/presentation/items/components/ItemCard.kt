package com.galaxy.evawiki.evainfo.presentation.items.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.galaxy.evawiki.evainfo.domain.model.Item

@Composable
fun ItemsCard(
    item: Item,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    imageCornerRadius: Dp = 8.dp,
    elevation: Dp = 8.dp
){
    Box(modifier = modifier){
        ElevatedCard(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(elevation),
            shape = RoundedCornerShape(cornerRadius)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                AsyncImage(
                    model = when(item){
                        is Item.Character -> item.picture
                        is Item.Stuff -> item.picture
                        is Item.Angel -> item.picture
                        is Item.Episode -> item.picture
                        is Item.Evangelion -> item.picture
                    },

                    contentDescription = "Character",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(imageCornerRadius)),
                    contentScale = ContentScale.FillBounds,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = when(item){
                        is Item.Character -> item.fullName
                        is Item.Stuff -> item.name
                        is Item.Angel -> item.name
                        is Item.Episode -> item.name
                        is Item.Evangelion -> item.name
                    },
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                if (item !is Item.Stuff){
                    Text(
                        text = when(item){
                            is Item.Character -> item.rank
                            is Item.Angel -> item.meaning
                            is Item.Episode -> item.number
                            is Item.Evangelion -> item.pilot
                            else -> ""
                        },
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
                Text(
                    text = when(item){
                        is Item.Character -> item.info
                        is Item.Stuff -> item.info
                        is Item.Angel -> item.info
                        is Item.Episode -> item.info
                        is Item.Evangelion -> item.info
                    },
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}