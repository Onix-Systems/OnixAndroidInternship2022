package com.onix.internship.arch.provider.model

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

sealed class TextProvider : Parcelable {
    @Parcelize
    data class Text(val text: String = "") : TextProvider() {
        override fun isEmpty(): Boolean {
            return text.isEmpty()
        }
    }

    @Parcelize
    data class ResText(@StringRes val text: Int = 0) : TextProvider() {
        override fun isEmpty(): Boolean {
            return text <= 0
        }
    }

    @Parcelize
    data class FormatResText(@StringRes val res: Int = 0, val text: String = "") : TextProvider() {
        override fun isEmpty(): Boolean {
            return text.isEmpty()
        }
    }

    abstract fun isEmpty(): Boolean
}
