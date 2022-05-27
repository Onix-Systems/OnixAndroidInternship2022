package com.onix.internship.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SplashFragmentBinding
import com.onix.internship.ui.chat.ChatFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashFragmentBinding>(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModel()

    override fun setObservers() {
        viewModel.initEvent.observe(this) { onInitUserEvent(it) }
        Handler(Looper.getMainLooper()).postDelayed({ checkToken() }, 500)
    }

    private fun checkToken() {
        if (!viewModel.hasToken()) {
            showLogInScreen()
        } else {
            viewModel.init()
        }
    }

    private fun onInitUserEvent(state: Boolean) {
        when (state) {
            true -> showMainScreen()
            else -> showLogInScreen()
        }
    }

    private fun showLogInScreen() {
        navigate(R.id.authFragment, clearStack = true)
    }

    private fun showMainScreen() {
        val args = Bundle().apply {
            this.putSerializable(ChatFragment.ARGS_USER, viewModel.user)
        }
        navigate(R.id.chatFragment, args, true)
    }

}