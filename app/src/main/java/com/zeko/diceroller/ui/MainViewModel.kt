package com.zeko.diceroller.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel(){

    private var list: List<Int>? = null
    val currImg: MutableLiveData<Int> = MutableLiveData()
    val currNumber: MutableLiveData<Int> = MutableLiveData()

    init {
        currNumber.postValue(0)
    }

    fun setList(imgList: List<Int>) {
        list = imgList
        currImg.postValue(list?.get(0))
    }

    fun clickRoll() {
        val rand = (1..6).random()
        currImg.postValue(list?.get(rand))
        currNumber.postValue(rand)
    }
}