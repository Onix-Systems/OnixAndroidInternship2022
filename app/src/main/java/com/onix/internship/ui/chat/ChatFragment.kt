package com.onix.internship.ui.chat

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.ChatFragmentBinding
import com.onix.internship.domain.entity.UserModel
import com.onix.internship.ui.chat.adapter.ChatAdapter
import com.onix.internship.ui.chat.adapter.ChatItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatFragment : BaseFragment<ChatFragmentBinding>(R.layout.chat_fragment) {

    companion object {
        const val ARGS_USER = "user"
    }

    override val viewModel: ChatViewModel by viewModel()
    private val chatAdapter: ChatAdapter by lazy { ChatAdapter() }

    override fun setObservers() {
        requireActivity().setTitle(R.string.title_messages)
        binding.viewModel = viewModel
        with(binding.rvChatList) {
            this.addItemDecoration(ChatItemDecoration(requireContext()))
            this.adapter = chatAdapter
        }
        viewModel.chatChannelEvent.observe(viewLifecycleOwner) { chatAdapter.setContent(it.channels) }
        getCurrentUser()?.let {
            viewModel.loadChatList(it)
        }
    }

    private fun getCurrentUser(): UserModel? {
        return arguments?.getSerializable(ARGS_USER) as? UserModel
    }

}