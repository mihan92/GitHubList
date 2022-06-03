package com.example.githublist.data.api


import com.example.githublist.domain.UserModelApi
import retrofit2.http.GET

interface ApiService {

    @GET("/search/repositories?q=users")
   suspend fun getUsers(): UserModelApi

}