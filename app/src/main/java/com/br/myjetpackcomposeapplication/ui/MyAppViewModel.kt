package com.br.myjetpackcomposeapplication.ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyAppViewModel @Inject constructor(myNav: NavHostController): ViewModel() {
    fun test() = "BORA BILL"
}