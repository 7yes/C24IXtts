package com.example.tts01.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VickVM @Inject constructor() : ViewModel() {

private val _title = MutableLiveData<String>()
val title: LiveData<String> = _title

    fun logIn(input: String): Boolean {
       var a=0
        try {
            a= input.toInt()
            if(a==605)_title.value="SELECT A TASK"
        }catch (_:Exception){

        }
       return a==605
    }
}
