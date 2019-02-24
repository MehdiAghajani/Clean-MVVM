package io.github.mehdi.clean.ui.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.mehdi.presentation.presenters.base.BaseViewModel

open class BaseAdapter<T, B: ViewDataBinding>(
    private val layoutId: Int,
    private val itemId: Int,
    private var items: List<T>,
    private val viewModelId:Int = 0,
    private val viewModel: BaseViewModel? = null,
    var onBind: B.(options: Int) -> Unit = {}
): RecyclerView.Adapter<BaseViewHolder<T, B>>()
{
    override fun getItemViewType(position: Int) = getLayoutIdForPosition(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, B> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: B = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.bind(items[position], itemId, viewModel, viewModelId)
        holder.binding.onBind(position)
    }

    fun getLayoutIdForPosition(position: Int): Int = layoutId

    fun swapItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition] == newItems[newItemPosition]

            override fun getOldListSize(): Int =
                items.size

            override fun getNewListSize(): Int =
                newItems.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition] == newItems[newItemPosition]
        })
        diffResult.dispatchUpdatesTo(this)
        items = newItems.toList()
    }

    interface OnItemClickListener<T> {
        fun onItemClick(view: View, item: T, position: Int = -1)
    }

}