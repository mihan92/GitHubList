package com.example.githublist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.githublist.R
import com.example.githublist.databinding.ActivityItemInfoBinding
import com.example.githublist.domain.UsersItem

class ActivityItemInfo : AppCompatActivity() {

    private lateinit var binding: ActivityItemInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getSerializableExtra("intent") as UsersItem

        binding.tvId.text = getString(R.string.tv_id, data.id.toString())
        binding.tvLogin.text = getString(R.string.tv_login, data.owner.login)
        binding.tvName.text = getString(R.string.tv_name, data.name)
        binding.tvDescription.text = getString(R.string.tv_description, data.description)
        binding.imageView.setImageResource(R.drawable.no_image)

        Glide.with(this).load(data.owner.avatar_url).into(binding.imageView)
    }
}