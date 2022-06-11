package com.onix.internship.ui.splash

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SplashFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashFragmentBinding>(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModel()

    override fun setObservers() {
        viewModel.initEvent.observe(this) {
            if (it) showLogInScreen()
        }
    }

    private fun showLogInScreen() {
        navigate(R.id.canvasFragment, clearStack = true)
    }

}