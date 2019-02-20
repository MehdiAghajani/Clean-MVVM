package io.github.MehdiAghajani.data.repositories.storage

interface StorageCache
{
    suspend fun saveToken(value: String)
    suspend fun getToken(): String
}