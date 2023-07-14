package com.example.roomdbdemo

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserRecyclerViewAdapter(val listener: onClicked) :
    RecyclerView.Adapter<UserRecyclerViewAdapter.userViewHolder>() {

//    var item = ArrayList<UserDataClass>()

    var itemArray: ArrayList<UserDataClass> = ArrayList()


    class userViewHolder(itemView: View, val listener: onClicked) :
        RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.display_name)
        val gender = itemView.findViewById<TextView>(R.id.display_gender)
        val age = itemView.findViewById<TextView>(R.id.display_age)
        var delete = itemView.findViewById<ImageView>(R.id.Delete_image)

        fun bind(data: UserDataClass) {
            name.text = data.name
            gender.text = data.gender
            age.text = data.age.toString()

            delete.setOnClickListener {
                listener.onDeleteData(data)
            }

            itemView.setOnClickListener {
                listener.onItemClicked(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return userViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return itemArray.size
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        holder.bind(itemArray[position])
    }


    fun setData(data: ArrayList<UserDataClass>) {
        this.itemArray.clear()
        this.itemArray = data
        notifyDataSetChanged()
    }

    interface onClicked {
        fun onDeleteData(data: UserDataClass)
        fun onItemClicked(data: UserDataClass)
    }
}