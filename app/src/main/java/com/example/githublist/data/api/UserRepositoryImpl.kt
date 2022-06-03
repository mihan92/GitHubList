package com.example.githublist.data.api

import com.example.githublist.domain.UserRepository
import com.example.githublist.domain.UsersItem


class UserRepositoryImpl : UserRepository {

    private var userList = mutableListOf<UsersItem>()

    override suspend fun getUserList(): List<UsersItem> {
        val response = RetrofitBuilder.apiService.getUsers()
        val body = response.items
        userList = (body.toList() as MutableList<UsersItem>)
        return userList
    }


}