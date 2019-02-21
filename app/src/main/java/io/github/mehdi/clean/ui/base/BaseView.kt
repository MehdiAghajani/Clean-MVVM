package io.github.mehdi.clean.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import io.github.mehdi.presentation.presenters.base.BaseViewModel

interface BaseView<V : BaseViewModel, B: ViewDataBinding>
{
    var viewModelFactory: ViewModelProvider.Factory
    val viewModel: V
    val layoutId: Int
    var binding: B

    fun onViewInitiailized(binding: B) {}
}