package io.github.mehdi.data.repositories.storage

import javax.inject.Inject

class LocalDataStoreFactory
@Inject constructor(private val cache: StorageCache)
{
    suspend fun saveToken(value: String) = cache.saveToken(value)
    suspend fun getToken() = cache.getToken()
}