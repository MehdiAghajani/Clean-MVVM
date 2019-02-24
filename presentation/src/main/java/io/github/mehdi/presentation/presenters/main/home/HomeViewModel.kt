package io.github.mehdi.presentation.presenters.main.home

import android.util.Log
import io.github.mehdi.domain.model.DomainCountryModel
import io.github.mehdi.domain.model.wrapper.APIResponse
import io.github.mehdi.domain.model.wrapper.ErrorResponse
import io.github.mehdi.domain.model.wrapper.SuccessResponse
import io.github.mehdi.domain.usecase.country.GetCountryListUseCase
import io.github.mehdi.presentation.presenters.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel
@Inject constructor(
    private val getCountryUseCase: GetCountryListUseCase
)
    : BaseViewModel()
{
    fun getCountryList(){
        getCountryUseCase.execute(jobLis, this::onCountryListResponse)
    }

    private fun onCountryListResponse(response: APIResponse<List<DomainCountryModel>>){
        when(response){
            is SuccessResponse -> {
                Log.d("Response", "Success")
            }
            is ErrorResponse -> {
                Log.d("Response", "Error")
            }
        }
    }
}