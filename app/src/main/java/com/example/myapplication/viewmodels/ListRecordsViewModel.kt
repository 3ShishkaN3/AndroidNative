package com.example.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListRecordsViewModel : ViewModel() {
    private val _name = MutableLiveData("Ada")
    val name: LiveData<String> = _name
}