package com.onix.internship.ui.chat.adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.databinding.ItemChatChannelBinding
import com.onix.internship.domain.entity.ChannelModel

class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemChatChannelBinding.bind(view)

    fun bind(model: ChannelModel) {
        binding.data = model
    }

}