package io.github.mehdi.data.repositories.storage

interface StorageCache
{
    suspend fun saveLastLaunch(value: Long)
    suspend fun getLastLaunch(): Long
}