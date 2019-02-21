package io.github.mehdi.clean.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import io.github.mehdi.presentation.viewModel.base.ViewModelScope
import io.github.mehdi.presentation.viewModel.base.BaseViewModel
import javax.inject.Inject

abstract class BaseFragment<V: BaseViewModel, B: ViewDataBinding>: Fragment(), BaseView<V, B>
{
    override lateinit var binding: B
    @Inject override lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified T: BaseViewModel> getLazyViewModel(scope: ViewModelScope): Lazy<T> =
            lazy {
                when(scope){
                    ViewModelScope.ACTIVITY -> ViewModelProviders.of(requireActivity(), viewModelFactory)[T::class.java]
                    ViewModelScope.FRAGMENT -> ViewModelProviders.of(this, viewModelFactory)[T::class.java]
                    ViewModelScope.PARENT_FRAGMENT -> ViewModelProviders.of(this.parentFragment!!, viewModelFactory)[T::class.java]
                    ViewModelScope.TARGET_FRAGMENT -> ViewModelProviders.of(this.targetFragment!!, viewModelFactory)[T::class.java]
                }
            }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.activityAction.observe(this, Observer { it?.invoke(requireActivity()) })
        viewModel.fragmentAction.observe(this, Observer { it?.invoke(this) })
        onViewInitiailized(binding)
    }
}