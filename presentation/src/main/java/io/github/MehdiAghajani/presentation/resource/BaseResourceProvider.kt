package io.github.MehdiAghajani.presentation.resource

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import java.io.InputStream

/**
 * Resolves application's resources.
 */
interface BaseResourceProvider {

    /**
     * Resolves text's id to String.
     *
     * @param id to be fetched from the resources
     * @return String representation of the {@param id}
     */
    fun getString(@StringRes id: Int): String

    /**
     * Resolves text's id to String and formats it.
     *
     * @param resId      to be fetched from the resources
     * @param formatArgs format arguments
     * @return String representation of the {@param resId}
     */
    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String

    /**
     * Resolves color's id to int
     *
     * @param resId to ne fetched from the resources
     * @return Int representation of the {@param id}
     */
    fun getColor(@ColorRes resId: Int): Int

    /**
     * Resolves drawable's id to Drawable
     *
     * @param resId to ne fetched from the resources
     * @return Drawable representation of the {@param id}
     */
    fun getDrawable(@DrawableRes resId: Int): Drawable?

    /**
     * Resolves asset name to to Inputstream
     *
     * @param assetName to  fetched from the asset
     * @return InputStream
     */
    fun getAsset(fileName: String): InputStream

    /**
     * Resolves uri to Inputstream
     *
     * @param uri
     * @return InputStream
     */
    fun getContentInputStream(uri: Uri): InputStream?

    /**
     * Resolves color's id to int
     *
     * @param fontRes to ne fetched from the assets
     * @return Typeface representation of the {@param id}
     */
    fun getTypeface(@FontRes fontRes: Int): Typeface?

    fun getMimType(uri: Uri): String?

    fun getContentResolver(): ContentResolver

    fun getBitmapFromVectorDrawable(@DrawableRes drawableId: Int): Bitmap
}
