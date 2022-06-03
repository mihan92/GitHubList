package com.example.githublist.domain.usecases

import com.example.githublist.data.api.UserRepositoryImpl
import com.example.githublist.domain.UsersItem

class GetUserListUseCase {

    private val userRepositoryImpl = UserRepositoryImpl()

    suspend fun getUserList(): List<UsersItem>{
        return userRepositoryImpl.getUserList()
    }
}