package com.example.githublist.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.githublist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getUserList()
        initObservers()
        setupRecyclerView()
    }

    private fun initObservers() {
        viewModel.userList.observe(this) {
            when (it) {
                is State.Data -> {
                    userListAdapter.userList = it.data
                    binding.progressBar.isVisible = false
                }
                is State.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is State.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerView
        userListAdapter = UserListAdapter()
        recyclerView.adapter = userListAdapter

        userListAdapter.onUserListClickListener = {
            val intent = Intent(this, ActivityItemInfo::class.java)
            intent.putExtra("intent", it)
            startActivity(intent)
        }
    }
}