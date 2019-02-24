package io.github.mehdi.data.repositories.storage

import io.github.mehdi.domain.repository.LocalStorageRepository
import javax.inject.Inject

class LocalStorageDataStore
@Inject constructor(private val factory: LocalDataStoreFactory)
    : LocalStorageRepository
{
    override suspend fun saveLastLaunch(value: Long) = factory.saveLastLaunch(value)

    override suspend fun getLastLaunch() = factory.getLastLaunch()
}