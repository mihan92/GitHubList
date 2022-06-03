package com.example.githublist.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserModelApi(
    @SerializedName("items") val items: List<UsersItem>
)


data class UsersItem(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("owner") val owner: Owner
): Serializable

data class Owner(
    @SerializedName("id") val id: Int,
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatar_url: String
): Serializable