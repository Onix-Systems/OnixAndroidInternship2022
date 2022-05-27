package com.onix.internship.arch.adapter

interface AdapterContentElement {

    fun areContentsTheSame(other: AdapterContentElement): Boolean
}