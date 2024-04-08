package com.galaxy.evawiki.evainfo.presentation.item.components

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.galaxy.evawiki.evainfo.domain.model.Item
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun CharacterFullCard(
    modifier: Modifier = Modifier,
    character: Item.Character,
    cornerRadius: Dp = 16.dp,
    imageCornerRadius: Dp = 8.dp,
    elevation: Dp = 8.dp

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
                    model = character.picture,
                    contentDescription = "Character",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(imageCornerRadius)),
                    contentScale = ContentScale.FillBounds,
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    title = "Name:",
                    text = character.fullName
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    title = "Age:",
                    text = "${character.age} (born ${character.dateOfBirth})"
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    title = "Rank:",
                    text = character.rank
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    title = "Blood Type:",
                    text = character.bloodType
                )
                Spacer(modifier = Modifier.height(32.dp))
                InfoSection(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    title = "Biography",
                    text = character.bio
                )
            }
        }
    }
}