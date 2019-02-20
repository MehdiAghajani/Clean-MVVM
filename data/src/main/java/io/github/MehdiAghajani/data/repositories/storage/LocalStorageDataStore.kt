package io.github.MehdiAghajani.data.repositories.storage

import io.github.MehdiAghajani.domain.repository.LocalStorageRepository
import javax.inject.Inject

class LocalStorageDataStore
@Inject constructor(private val factory: LocalDataStoreFactory)
    : LocalStorageRepository
{
    override suspend fun saveToken(value: String) = factory.saveToken(value)

    override suspend fun getToken() = factory.getToken()
}