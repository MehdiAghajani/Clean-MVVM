package io.github.mehdi.presentation.presenters.splash

import androidx.lifecycle.MutableLiveData
import io.github.mehdi.domain.repository.LocalStorageRepository
import io.github.mehdi.presentation.presenters.base.BaseViewModel
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

class SplashViewModel
@Inject constructor(
    private val localStorgaRepository: LocalStorageRepository,
    private val navigator: SplashNavigator
)
    : BaseViewModel()
{
    companion object {
        private const val DELAY_TIME_IN_MILISECONDS = 2000L
    }

    val dateTimeLiveData: MutableLiveData<Date> = MutableLiveData()

    fun openMainPage(){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){

                dateTimeLiveData.postValue(Date(localStorgaRepository.getLastLaunch()))

                delay(DELAY_TIME_IN_MILISECONDS)

                localStorgaRepository.saveLastLaunch(System.currentTimeMillis())
            }
           activityAction{ navigator.openMainPage(it) }
        }
    }
}