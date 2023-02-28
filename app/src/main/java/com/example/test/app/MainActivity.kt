package com.example.test.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.test.viewModel.MainViewModel
import com.example.test.adapter.PetsAdapter
import com.example.test.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val scope =
        MainScope() // could also use an other scope such as viewModelScope if available
    lateinit var jokesAdapter: PetsAdapter
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        lifecycleScope.launchWhenResumed {

            jokesAdapter=PetsAdapter(this@MainActivity)
            binding.rvJokes.adapter = jokesAdapter
            binding.rvJokes.addItemDecoration(
                DividerItemDecoration(
                    binding.rvJokes.getContext(), DividerItemDecoration.VERTICAL
                )
            )
            jokesAdapter.setItems(

                mainViewModel.fetchPets(this@MainActivity))
             }
    }






}