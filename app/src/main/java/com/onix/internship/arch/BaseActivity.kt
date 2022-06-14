package com.onix.internship.arch

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val resId: Int) :
    AppCompatActivity() {

    private lateinit var binding: T
    protected abstract val viewModel: BaseViewModel
    protected abstract val navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
    }

    protected fun showFragment(resId: Int, args: Bundle? = null, clearStack: Boolean = false) {
        if (clearStack) {
            navController.popBackStack()
        }
        navController.navigate(resId, args)
    }
}