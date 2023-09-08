package com.tharunbalaji.tweetzy.api

import com.tharunbalaji.tweetzy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetzyAPI {
    @GET("/v3/b/64f8abbee4033326cbd3162e?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    @GET("/v3/b/64f8abbee4033326cbd3162e?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}