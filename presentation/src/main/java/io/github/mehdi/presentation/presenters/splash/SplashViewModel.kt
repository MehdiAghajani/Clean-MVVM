package io.github.mehdi.presentation.presenters.splash

import io.github.mehdi.presentation.presenters.base.BaseViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

class SplashViewModel
@Inject constructor(
    private val navigator: SplashNavigator
)
    : BaseViewModel()
{
    companion object {
        private const val DELAY_TIME_IN_MILISECONDS = 1000L
    }

    fun openMainPage(){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                delay(DELAY_TIME_IN_MILISECONDS)
            }
           activityAction{ navigator.openMainPage(it) }
        }
    }
}