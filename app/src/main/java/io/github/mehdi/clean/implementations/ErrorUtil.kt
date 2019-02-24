package io.github.mehdi.clean.implementations

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.github.mehdi.domain.model.error.ErrorModel
import io.github.mehdi.domain.model.error.ErrorStatus
import io.github.mehdi.domain.usecase.UseCaseErrorUtil
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import javax.inject.Inject

class ErrorUtil
@Inject constructor(val gson: Gson)
    :UseCaseErrorUtil
{
    override fun getErrorModel(e: Exception?): ErrorModel {
        if (e == null) {
            return ErrorModel(ErrorStatus.NOT_DEFINED)
        }
        if (e is HttpException) {
            return if (e.code() == 401)
                ErrorModel(ErrorStatus.UNAUTHORIZED)
//            else if(t.code() == 404)
//                ErrorModel(ErrorStatus.NOT_FOUND)
            else
                getHttpError(e.response().errorBody(), e.code())
        }
        if (e is SocketTimeoutException) {
            return ErrorModel(ErrorStatus.TIMEOUT)
        }
        if (e is IOException) {
            return ErrorModel(ErrorStatus.NO_CONNECTION)
        }
        return if (e is NullPointerException) {
            ErrorModel(ErrorStatus.EMPTY_RESPONSE)
        } else ErrorModel(ErrorStatus.NOT_DEFINED)
    }

    private fun getHttpError(body: ResponseBody?, code: Int): ErrorModel {
        return try {

            val listType = object : TypeToken<List<ErrorModel>>() {}.type
            val errorModelList: List<ErrorModel> = gson.fromJson(body!!.string(), listType)
            errorModelList[0].also {
                if(code==404)
                    it.errorStatus = ErrorStatus.NOT_FOUND
                else
                    it.errorStatus = ErrorStatus.BAD_RESPONSE
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            ErrorModel(ErrorStatus.NOT_DEFINED)
        }

    }
}