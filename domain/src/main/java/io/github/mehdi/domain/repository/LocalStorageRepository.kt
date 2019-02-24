package io.github.mehdi.domain.repository

interface LocalStorageRepository
{
    suspend fun saveLastLaunch(value: Long)
    suspend fun getLastLaunch(): Long
}