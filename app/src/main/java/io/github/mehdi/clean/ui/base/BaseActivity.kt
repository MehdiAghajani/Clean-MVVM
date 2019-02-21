package io.github.mehdi.clean.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import io.github.mehdi.presentation.viewModel.base.BaseViewModel
import javax.inject.Inject

abstract class BaseActivity<V: BaseViewModel, B: ViewDataBinding>: AppCompatActivity(), BaseView<V, B>
{
    override lateinit var binding: B
    @Inject override lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified T: BaseViewModel> getLazyViewModel(): Lazy<T> =
            lazy { ViewModelProviders.of(this, viewModelFactory)[T::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
        viewModel.activityAction.observe(this, Observer { it?.invoke(this) })
        onViewInitiailized(binding)
    }
}