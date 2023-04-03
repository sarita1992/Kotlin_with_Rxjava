package com.example.test.ui.userlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.data.Result
import com.example.test.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListActivity : AppCompatActivity() {
    var resultList = ArrayList<Result?>()
    private lateinit var userAdapter: UserAdapter
    private val userListViewModel: UserListViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private val pagination = 10
    var mLayoutManager: LinearLayoutManager? = null
    var isLoading = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        userAdapter = UserAdapter()
        userListViewModel.userList.observe(this, Observer {
            it?.let {
                resultList.addAll(it.results ?: emptyList())
                userAdapter.setItems(resultList)
                isLoading = false
                var pos=0
                pos = if (mLayoutManager == null) {
                    0
                } else {
                    mLayoutManager!!.findLastVisibleItemPosition()
                }
                if (binding.rvUsersList != null) {
                    mLayoutManager = LinearLayoutManager(this@ListActivity)
                    binding.rvUsersList.layoutManager = mLayoutManager
                    binding.rvUsersList.adapter = userAdapter
                    binding.rvUsersList.scrollToPosition(pos)
                    binding.rvUsersList.addOnScrollListener(recyclerViewOnScrollListener)
                }
            }
        })
        userListViewModel.fetchUsers(pagination)
    }

    private val recyclerViewOnScrollListener: RecyclerView.OnScrollListener =
        object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastItem = mLayoutManager?.findLastCompletelyVisibleItemPosition()
                if (lastItem == resultList.size?.minus(1) ?: -1) {
                    if (!isLoading) {
                        isLoading = true
                        userListViewModel.fetchUsers(pagination)
                    }
                }
            }
        }

}