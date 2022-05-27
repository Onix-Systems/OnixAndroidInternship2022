package com.onix.internship.arch.adapter

import androidx.recyclerview.widget.DiffUtil

open class AbstractDiffCallback<E>(
    private val newList: List<E>,
    private val oldList: List<E>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val new = newList.getOrNull(newItemPosition) as? AdapterContentElement ?: return false
        val old = oldList.getOrNull(newItemPosition) as? AdapterContentElement ?: return false

        return new.areContentsTheSame(old)
    }
}