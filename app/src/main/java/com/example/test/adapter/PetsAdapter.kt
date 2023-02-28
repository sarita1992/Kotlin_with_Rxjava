package com.example.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.test.R
import com.example.test.databinding.LayoutUserAdapterBinding
import com.example.test.model.PetsMain

class PetsAdapter(val mainActivity: Context) : RecyclerView.Adapter<PetsAdapter.JokesViewHolder>() {

    var userList = mutableListOf<PetsMain>()

//    init {
//        userList = userData
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val binding =
            LayoutUserAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokesViewHolder(binding)
    }


    override fun onViewRecycled(holder: JokesViewHolder) {
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        var i = position
        i = (i + 1)
        with(holder) {
            binding.tvJoke.text =  userList[position].title
            Glide.with(mainActivity)
                .load(userList[position].imageurl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(binding.ivImage)
        }

    }

    fun setItems(it: ArrayList<PetsMain>) {

        userList.addAll(it)
        notifyDataSetChanged()
    }


    inner class JokesViewHolder(val binding: LayoutUserAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)
}