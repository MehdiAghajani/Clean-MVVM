package io.github.mehdi.domain.usecase

import io.github.mehdi.domain.model.error.ErrorModel
import java.lang.Exception

interface UseCaseErrorUtil {
    fun getErrorModel(e: Exception): ErrorModel
}