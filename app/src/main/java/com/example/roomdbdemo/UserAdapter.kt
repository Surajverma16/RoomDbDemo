package com.example.roomdbdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class UserAdapter : ListAdapter<UserDataClass, UserAdapter.UserViewHolder>(UserComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName: TextView = itemView.findViewById(R.id.display_name)

        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                val itemView =
                    LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
                return UserViewHolder(itemView)
            }
        }
    }

    companion object {
        private val UserComparator = object : DiffUtil.ItemCallback<UserDataClass>() {
            override fun areItemsTheSame(oldItem: UserDataClass, newItem: UserDataClass): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: UserDataClass,
                newItem: UserDataClass,
            ): Boolean {
                return oldItem == newItem

            }

        }
    }


}