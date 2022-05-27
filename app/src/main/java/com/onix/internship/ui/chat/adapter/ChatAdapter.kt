package com.onix.internship.ui.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.onix.internship.R
import com.onix.internship.arch.adapter.BaseRecyclerAdapter
import com.onix.internship.domain.entity.ChannelModel
import com.onix.internship.ui.chat.adapter.holders.ChatViewHolder

class ChatAdapter : BaseRecyclerAdapter<ChatViewHolder, ChannelModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat_channel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(adapterItems[position])
    }
}