package com.onix.internship.ui.auth

import android.os.Bundle
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.AuthFragmentBinding
import com.onix.internship.domain.entity.UserModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseFragment<AuthFragmentBinding>(R.layout.auth_fragment) {

    override val viewModel: AuthViewModel by viewModel()

    override fun setObservers() {
        binding.viewModel = viewModel
        viewModel.logInEvent.observe(viewLifecycleOwner) { toMainScreen(it) }
    }

    private fun toMainScreen(userModel: UserModel) {
        val args = Bundle().apply {
            //this.putSerializable(ChatFragment.ARGS_USER, userModel)
        }
        //navigate(R.id.chatFragment, args)
    }

}