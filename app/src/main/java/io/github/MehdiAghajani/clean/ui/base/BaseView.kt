package io.github.MehdiAghajani.clean.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import io.github.MehdiAghajani.presentation.viewModel.base.BaseViewModel

interface BaseView<V : BaseViewModel, B: ViewDataBinding>
{
    var viewModelFactory: ViewModelProvider.Factory
    val viewModel: V
    val layoutId: Int
    var binding: B

    fun onViewInitiailized(binding: B) {}
}