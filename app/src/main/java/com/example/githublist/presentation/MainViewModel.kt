package com.example.githublist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githublist.domain.UsersItem
import com.example.githublist.domain.usecases.GetUserListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val getUserListUseCase =  GetUserListUseCase()

    private val _userList = MutableLiveData<State<List<UsersItem>>>()
    val userList: LiveData<State<List<UsersItem>>> = _userList

    private var job: Job? = null


    fun getUserList() {
        job?.cancel()
        job = viewModelScope.launch {
            _userList.value = State.Loading()
            try {
               _userList.value = State.Data(getUserListUseCase.getUserList())
            } catch (e: Exception) {
                _userList.value = State.Error(e)
            }
        }
    }
}