package io.github.MehdiAghajani.presentation.viewModel.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.github.MehdiAghajani.presentation.util.livedata.ActivityActionLiveData
import io.github.MehdiAghajani.presentation.util.livedata.FragmentActionLiveData

abstract class BaseViewModel()
    :ViewModel(), LifecycleObserver
{
    val activityAction by lazy { ActivityActionLiveData() }
    val fragmentAction by lazy { FragmentActionLiveData() }

    override fun onCleared() {
        super.onCleared()
    }
}