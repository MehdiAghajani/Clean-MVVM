package io.github.mehdi.cache.preference

import android.content.Context
import io.github.mehdi.data.repositories.storage.StorageCache

class PreferenceImpl(context: Context) : StorageCache
{
    companion object {
        private const val PREF_NAME = "app_pref"

        private const val LAST_LAUNCH_KEY = "LastLaunchKey"
    }

    val prefs by lazy { context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) }


    override suspend fun saveLastLaunch(value: Long) = prefs.edit().putLong(LAST_LAUNCH_KEY, value).apply()

    override suspend fun getLastLaunch() = prefs.getLong(LAST_LAUNCH_KEY, System.currentTimeMillis())
}