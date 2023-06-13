package com.example.testfragment.activitis

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val nameActivityTraining: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val nameTraining: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val nameWorkout: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}