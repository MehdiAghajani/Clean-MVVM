package io.github.mehdi.presentation.presenters.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.github.mehdi.presentation.util.livedata.ActivityActionLiveData
import io.github.mehdi.presentation.util.livedata.FragmentActionLiveData
import kotlinx.coroutines.Job

abstract class BaseViewModel()
    :ViewModel(), LifecycleObserver
{

    //TODO replace it with better solution
    val jobLis: MutableList<Job> = mutableListOf()

    val activityAction by lazy { ActivityActionLiveData() }
    val fragmentAction by lazy { FragmentActionLiveData() }

    override fun onCleared() {
        super.onCleared()
        jobLis.forEach { if(it.isActive) it.cancel() }
    }
}