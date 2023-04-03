package com.example.test

import com.example.test.ui.userlist.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val networkModule = module {
    single { createBasicAuthService() }
}


val viewModelModule = module {

    viewModel {
        UserListViewModel(get())
    }
}