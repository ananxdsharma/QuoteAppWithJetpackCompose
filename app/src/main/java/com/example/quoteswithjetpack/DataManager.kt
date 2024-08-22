package com.example.quoteswithjetpack

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quoteswithjetpack.models.quote
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope

object DataManager {

    var data= emptyArray<quote>()
    var currentQuote:quote? = null

    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded  = mutableStateOf(false)

    fun loadAssetFromFile(context: Context){

        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<quote>::class.java)
        isDataLoaded.value=true
    }
    
    fun switchPages(q:quote?){

        if(currentPage.value==Pages.LISTING){
            currentQuote=q
            currentPage.value=Pages.DETAIL
        }else{
            currentPage.value=Pages.LISTING

        }
    }
}