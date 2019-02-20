package io.github.MehdiAghajani.domain.model.wrapper

import io.github.MehdiAghajani.domain.model.error.ErrorModel

sealed class APIResponse<out T>
data class SuccessResponse<out T>(val value: T): APIResponse<T>()
data class ErrorResponse<out T>(val error: ErrorModel): APIResponse<T>()