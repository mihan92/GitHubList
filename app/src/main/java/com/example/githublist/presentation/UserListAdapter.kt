package com.example.githublist.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githublist.R
import com.example.githublist.domain.UsersItem

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    var userList = listOf<UsersItem>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onUserListClickListener: ((UsersItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return UserListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val listItem = userList[position]
        holder.tvName.text = listItem.name
        holder.tvDescription.text = listItem.description
        holder.itemView.setOnClickListener {
            onUserListClickListener?.invoke(listItem)
        }
        Glide.with(holder.image).load(listItem.owner.avatar_url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)
        val image: ImageView = view.findViewById(R.id.image_view)
    }
}