package io.github.mehdi.clean.ui

import io.github.mehdi.clean.R
import io.github.mehdi.clean.databinding.ActivitySplashBinding
import io.github.mehdi.clean.ui.base.BaseActivity
import io.github.mehdi.presentation.viewModel.splash.SplashViewModel

class SplashActivity: BaseActivity<SplashViewModel, ActivitySplashBinding>()
{
    override val viewModel: SplashViewModel by getLazyViewModel()
    override val layoutId: Int get() = R.layout.activity_splash

    override fun onViewInitiailized(binding: ActivitySplashBinding) {
        binding.viewModel = viewModel
    }
}