package io.github.mehdi.presentation.presenters.main

import io.github.mehdi.presentation.presenters.base.BaseViewModel
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val navigator: MainNavigator
)
    : BaseViewModel()
{
    fun openHomePage(){
        activityAction{ navigator.openHomePage(it) }
    }
}