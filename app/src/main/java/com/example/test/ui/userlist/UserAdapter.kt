package com.example.test.ui.userlist

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cookpad.hiring.android.tools.loadImage
import com.example.test.app.MyApp
import com.example.test.data.Result
import com.example.test.databinding.LayoutUserAdapterBinding
import com.example.test.ui.userdetail.DetailActivity


class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var userList = mutableListOf<Result?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            LayoutUserAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onViewRecycled(holder: UserViewHolder) {
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder) {
            binding.userDetail.text =  userList[position]?.location?.city+" "+ userList[position]?.location?.country
            binding.userName.text =  userList[position]?.name?.title+" "+ userList[position]?.name?.first+" "+ userList[position]?.name?.last
            binding.userImage.loadImage(userList[position]?.picture?.medium)
            binding.mainView.setOnClickListener {
                val next = Intent(MyApp.instance, DetailActivity::class.java)
                next.putExtra("Data", userList[position])
                next.flags = FLAG_ACTIVITY_NEW_TASK
                MyApp.instance.startActivity(next)
            }
        }
    }

    fun setItems(it: List<Result?>?) {
        userList.addAll(it!!)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: LayoutUserAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

}