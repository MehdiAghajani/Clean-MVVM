package io.github.mehdi.clean.ui.splash

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import io.github.mehdi.clean.ui.main.MainActivity
import io.github.mehdi.presentation.presenters.splash.SplashNavigator
import javax.inject.Inject

class SplashNavigatorImpl
@Inject constructor()
    : SplashNavigator
{
    override fun openMainPage(activity: FragmentActivity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }
}