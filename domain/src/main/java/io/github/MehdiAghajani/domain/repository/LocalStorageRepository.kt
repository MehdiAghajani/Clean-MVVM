package io.github.MehdiAghajani.domain.repository

interface LocalStorageRepository
{
    suspend fun saveToken(value: String)
    suspend fun getToken(): String
}