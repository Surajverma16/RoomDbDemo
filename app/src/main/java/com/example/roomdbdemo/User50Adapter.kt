package com.example.roomdbdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class User50Adapter(var itemArray : List<UserDataClass>) : RecyclerView.Adapter<User50Adapter.User50ViewHolder>() {

    fun setData( data : ArrayList<UserDataClass>){
        this.itemArray = data
    }
    class User50ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name =  itemView.findViewById<TextView>(R.id.display_name)
        val gender =  itemView.findViewById<TextView>(R.id.display_gender)
        val age =  itemView.findViewById<TextView>(R.id.display_age)
        val delete = itemView.findViewById<ImageView>(R.id.Delete_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): User50ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return User50ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemArray.size
    }

    override fun onBindViewHolder(holder: User50ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
