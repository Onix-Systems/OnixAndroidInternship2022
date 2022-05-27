package com.onix.internship.ui.chat.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.onix.internship.R

class ChatItemDecoration(val context: Context) :
    DividerItemDecoration(context, LinearLayoutManager.VERTICAL) {

    init {
        ContextCompat.getDrawable(context, R.drawable.divider)?.let {
            setDrawable(it)
        }
    }

}