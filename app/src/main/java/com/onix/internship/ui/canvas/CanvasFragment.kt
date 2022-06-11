package com.onix.internship.ui.canvas

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.CanvasFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CanvasFragment : BaseFragment<CanvasFragmentBinding>(R.layout.canvas_fragment) {

    override val viewModel: CanvasViewModel by viewModel()

}