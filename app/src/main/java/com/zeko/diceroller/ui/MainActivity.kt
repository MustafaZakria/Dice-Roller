package com.zeko.diceroller.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zeko.diceroller.R
import com.zeko.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


//        val imgArray = listOf(R.drawable.empty_dice, R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
//            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        viewModel.setList(getListOfImgs())
    }

    fun getListOfImgs(): MutableList<Int> {
        val imgList = mutableListOf<Int>()
        for (i in 0..6) {
            val resourceName = "dice_$i"
            val resourceId = resources.getIdentifier(resourceName, "drawable", packageName)
            imgList.add(resourceId)
        }
        return imgList
    }
}