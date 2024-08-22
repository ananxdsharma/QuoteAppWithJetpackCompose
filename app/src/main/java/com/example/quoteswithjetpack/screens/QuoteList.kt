package com.example.quoteswithjetpack.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quoteswithjetpack.models.quote

@Composable
fun  QuoteList(data:Array<quote>, onClick: (q:quote)->Unit) {

    LazyColumn(content = {
        items(data){
            QuoteListItem(q = it,onClick)

        }
    })

}