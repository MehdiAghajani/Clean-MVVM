package io.github.mehdi.data.repositories.storage

import javax.inject.Inject

class LocalDataStoreFactory
@Inject constructor(private val cache: StorageCache)
{
    suspend fun saveLastLaunch(value: Long) = cache.saveLastLaunch(value)
    suspend fun getLastLaunch() = cache.getLastLaunch()
}