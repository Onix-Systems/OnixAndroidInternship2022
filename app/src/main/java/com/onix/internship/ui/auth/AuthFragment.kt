package com.onix.internship.ui.auth

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.AuthFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseFragment<AuthFragmentBinding>(R.layout.auth_fragment) {

    override val viewModel: AuthViewModel by viewModel()


}