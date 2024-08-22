package com.example.quoteswithjetpack.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quoteswithjetpack.DataManager
import com.example.quoteswithjetpack.models.quote

@Composable
fun QuoteDetail(q:quote) {

    BackHandler() {
        DataManager.switchPages(null)

    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ){
        Card(

            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            modifier = Modifier.padding(32.dp)


        ){

            Column(
                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment,
                modifier = Modifier
                    .padding(16.dp,24.dp)
            ){
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = null,
                    modifier= Modifier
                        .size(80.dp)
                        .rotate(180F)
                )
                Text(
                    text = q.text,
                    style = MaterialTheme.typography.headlineMedium

                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = q.author,
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }
    }

}