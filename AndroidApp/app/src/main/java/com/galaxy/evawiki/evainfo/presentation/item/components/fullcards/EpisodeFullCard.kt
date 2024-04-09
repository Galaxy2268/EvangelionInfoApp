package com.galaxy.evawiki.evainfo.presentation.item.components.fullcards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.presentation.item.components.InfoSection
import com.galaxy.evawiki.evainfo.presentation.item.components.TextRow

@Composable
fun EpisodeFullCard(
    modifier: Modifier = Modifier,
    episode: Item.Episode,
    cornerRadius: Dp = 16.dp,
    imageCornerRadius: Dp = 8.dp,
    elevation: Dp = 8.dp,
    verticalItemSpacing: Dp = 16.dp,
    horizontalItemSpacing: Dp = 8.dp
){
    Box(modifier = modifier) {
        ElevatedCard(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(elevation),
            shape = RoundedCornerShape(cornerRadius)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                AsyncImage(
                    model = episode.picture,
                    contentDescription = "Episode",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(imageCornerRadius)),
                    contentScale = ContentScale.FillBounds,
                )
                Spacer(modifier = Modifier.height(verticalItemSpacing))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalItemSpacing),
                    title = "Name",
                    text = episode.name
                )
                Spacer(modifier = Modifier.height(verticalItemSpacing))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalItemSpacing),
                    title = "Number",
                    text = episode.number
                )
                Spacer(modifier = Modifier.height(verticalItemSpacing))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalItemSpacing),
                    title = "Air Date",
                    text = episode.airDate
                )
                Spacer(modifier = Modifier.height(verticalItemSpacing))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalItemSpacing),
                    title = "Director",
                    text = episode.director
                )
                Spacer(modifier = Modifier.height(verticalItemSpacing))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalItemSpacing),
                    title = "Writer",
                    text = episode.writer
                )
                Spacer(modifier = Modifier.height(32.dp))
                InfoSection(
                    modifier = Modifier.padding(horizontal = horizontalItemSpacing),
                    title = "Information",
                    text = episode.info
                )
            }
        }
    }
}