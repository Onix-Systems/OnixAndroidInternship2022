package com.onix.internship.arch.ext

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onix.internship.utils.AppUtils

@BindingAdapter("circleImage", "placeholder", requireAll = false)
fun ImageView.bindCircleImage(image: String?, placeholder: Drawable?) {
    if (image.isNullOrEmpty()) {
        setImageDrawable(placeholder)
    } else {
        Glide.with(context)
            .load(Uri.parse(image))
            .apply(RequestOptions().circleCrop())
            .placeholder(placeholder)
            .error(placeholder)
            .into(this)
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("userName")
fun AppCompatTextView.bindUserName(name: String?) {
    val userName = if (name.isNullOrBlank()) {
        "Unknown"
    } else name
    text = "$userName:"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("dateFormat")
fun AppCompatTextView.bindDateTime(dateTime: String?) {
    if (!dateTime.isNullOrBlank()) {
        text = AppUtils.getDate(dateTime)
    }
}

@BindingAdapter("onRefresh")
fun SwipeRefreshLayout.onRefresh(callback: () -> Unit) {
    setOnRefreshListener {
        callback.invoke()
        isRefreshing = false
    }
}