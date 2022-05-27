package com.onix.internship.arch

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val resId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: T
    protected abstract val viewModel: BaseViewModel
    protected abstract val navController: NavController
    protected open fun setObservers() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)

        setObservers()
        viewModel.errorEvent.observe(this) { showToast(it) }
    }

    protected fun showFragment(resId: Int, args: Bundle? = null, clearStack: Boolean = false) {
        if (clearStack) {
            navController.popBackStack()
        }
        navController.navigate(resId, args)
    }

    protected fun showToast(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
    }
}