package com.example.test.ui.userdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cookpad.hiring.android.tools.loadImage
import com.example.test.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    var userData = com.example.test.data.Result()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        userData = intent.extras?.getParcelable("Data")!!

        binding.userImage.loadImage(this.userData.picture?.large)
        binding.tvName.text=userData.name?.title+" "+userData.name?.first+" "+userData.name?.last
        binding.tvLocation.text=userData.location?.city+", "+userData.location?.country
        binding.tvGender.text=userData.gender
        binding.tvPhone.text=userData.phone

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.title="Detail"
        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}