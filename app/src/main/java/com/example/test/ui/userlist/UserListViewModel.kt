package com.example.test.ui.userlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.networkCall.BasicApiService
import com.example.test.data.Users
import io.reactivex.schedulers.Schedulers
class UserListViewModel(val apiService: BasicApiService) : ViewModel() {

    val userList = MutableLiveData<Users>()
    fun fetchUsers(pagination: Int) {
        apiService.getAllUsers(""+pagination).subscribeOn(Schedulers.io())
            .subscribe({ result -> userList.postValue(result) },
                { throwable ->
                Log.e("error",""+throwable.message)
                })


    }

}