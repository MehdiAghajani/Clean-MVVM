package io.github.mehdi.clean.ui.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.github.mehdi.presentation.presenters.base.BaseViewModel

class BaseViewHolder<in T, out B: ViewDataBinding>(val binding: B): RecyclerView.ViewHolder(binding.root)
{
    fun bind(item: T, itemId: Int, viewModel: BaseViewModel? = null, viewModelId: Int){
        if(viewModel != null) binding.setVariable(viewModelId, viewModel)
        binding.setVariable(itemId, item)
        binding.executePendingBindings()
    }
}