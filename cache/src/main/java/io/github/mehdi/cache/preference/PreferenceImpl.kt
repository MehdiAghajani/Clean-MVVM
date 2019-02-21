package io.github.mehdi.cache.preference

import android.content.Context
import io.github.mehdi.data.repositories.storage.StorageCache

class PreferenceImpl(context: Context) : StorageCache
{
    companion object {
        private const val PREF_NAME = "app_pref"

        private const val TOKEN_KEY = "TokenKey"
    }

    val prefs by lazy { context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) }


    override suspend fun saveToken(value: String) = prefs.edit().putString(TOKEN_KEY, value).apply()

    override suspend fun getToken() = prefs.getString(TOKEN_KEY, "")
}