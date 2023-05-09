package com.zeko.diceroller.bindingadapters

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataBindingAdapters {

    companion object {
        @JvmStatic
        @BindingAdapter("drawableId")
        fun ImageView.loadImage(liveImageResId: MutableLiveData<Int>) {
            liveImageResId.observe(this.context as LifecycleOwner) { drawableResId ->
                this.setImageResource(drawableResId ?: 0)
            }
        }

    }
}