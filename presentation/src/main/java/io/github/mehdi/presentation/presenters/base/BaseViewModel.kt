package io.github.mehdi.presentation.presenters.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.github.mehdi.presentation.util.livedata.ActivityActionLiveData
import io.github.mehdi.presentation.util.livedata.FragmentActionLiveData

abstract class BaseViewModel()
    :ViewModel(), LifecycleObserver
{
    val activityAction by lazy { ActivityActionLiveData() }
    val fragmentAction by lazy { FragmentActionLiveData() }

    override fun onCleared() {
        super.onCleared()
    }
}