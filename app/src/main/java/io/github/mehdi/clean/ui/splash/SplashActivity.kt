package io.github.mehdi.clean.ui.splash

import android.widget.Toast
import androidx.lifecycle.Observer
import io.github.mehdi.clean.R
import io.github.mehdi.clean.databinding.ActivitySplashBinding
import io.github.mehdi.clean.ui.base.BaseActivity
import io.github.mehdi.clean.util.image.GlideApp
import io.github.mehdi.presentation.presenters.splash.SplashViewModel

class SplashActivity: BaseActivity<SplashViewModel, ActivitySplashBinding>()
{
    override val viewModel: SplashViewModel by getLazyViewModel()
    override val layoutId: Int get() = R.layout.activity_splash

    override fun onViewInitiailized(binding: ActivitySplashBinding) {
        binding.viewModel = viewModel
        GlideApp
            .with(this)
            .load(R.drawable.android_pie_logo)
            .into(binding.imgPie)

        viewModel.openMainPage()
        subscribeLiveData()
    }

    private fun subscribeLiveData(){
        viewModel.dateTimeLiveData.observe(this, Observer {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}