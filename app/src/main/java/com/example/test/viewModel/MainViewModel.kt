package com.example.test.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.test.app.MainActivity
import com.example.test.model.PetsMain

import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainViewModel() : ViewModel() {
    val userList = ArrayList<PetsMain>()


    fun fetchPets(mainActivity: MainActivity): ArrayList<PetsMain> {
        var json: String? = null
        try {
            val `is`: InputStream = mainActivity.assets.open("pets_list ).json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer)

            val objet = JSONObject(json)
            val arrray = objet.getJSONArray("pets")
            for (i in 0 until arrray.length()) {
                val jsonObject = arrray.getJSONObject(i)
                val petsMain = PetsMain()
                petsMain.imageurl = jsonObject.getString("image_url")
                petsMain.title = jsonObject.getString("title")
                petsMain.contentUrl = jsonObject.getString("content_url")
                petsMain.dateAdded = jsonObject.getString("date_added")
                userList.add(petsMain)
            }

        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return userList
    }

/**
 * This method is used for fetch time from config file
 * */
    fun fetchTime(mainActivity: MainActivity): String {

        var json: String? = null
        try {
            val `is`: InputStream = mainActivity.assets.open("config.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer)
            Log.e("json", "" + json)


        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return "userList"
    }

}