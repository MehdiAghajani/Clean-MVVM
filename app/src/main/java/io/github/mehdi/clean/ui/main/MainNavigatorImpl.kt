package io.github.mehdi.clean.ui.main

import androidx.fragment.app.FragmentActivity
import io.github.mehdi.clean.R
import io.github.mehdi.clean.ui.main.home.HomeFragment
import io.github.mehdi.presentation.presenters.main.MainNavigator
import javax.inject.Inject

class MainNavigatorImpl @Inject constructor(): MainNavigator
{
    override fun openHomePage(activity: FragmentActivity) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HomeFragment.newInstance())
            .commitAllowingStateLoss()
    }
}