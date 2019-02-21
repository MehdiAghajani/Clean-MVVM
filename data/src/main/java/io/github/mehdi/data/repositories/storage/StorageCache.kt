package io.github.mehdi.data.repositories.storage

interface StorageCache
{
    suspend fun saveToken(value: String)
    suspend fun getToken(): String
}