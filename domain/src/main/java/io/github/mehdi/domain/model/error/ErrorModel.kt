package io.github.mehdi.domain.model.error


data class ErrorModel(
        val path: String?,
        val message: String?,
        val code: Int?,
        var errorStatus: ErrorStatus
)
{
    constructor(errorStatus: ErrorStatus) : this(null, null, null, errorStatus)
}