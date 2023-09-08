package com.tharunbalaji.tweetzy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tharunbalaji.tweetzy.api.TweetzyAPI
import com.tharunbalaji.tweetzy.ui.theme.TweetzyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var tweetzyAPI: TweetzyAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            var response = tweetzyAPI.getCategories()
            Log.d("TWEETZY API",response.body()!!.distinct().toString())
        }

        setContent {
            TweetzyTheme {

            }
        }
    }
}

