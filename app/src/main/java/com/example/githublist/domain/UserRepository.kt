package com.example.githublist.domain


interface UserRepository {

    suspend fun getUserList(): List<UsersItem>

}