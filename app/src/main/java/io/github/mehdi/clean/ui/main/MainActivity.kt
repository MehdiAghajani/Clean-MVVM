package io.github.mehdi.clean.ui.main

import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.github.mehdi.clean.R
import io.github.mehdi.clean.databinding.ActivityMainBinding
import io.github.mehdi.clean.ui.base.BaseActivity
import io.github.mehdi.presentation.presenters.main.MainViewModel
import javax.inject.Inject

class MainActivity: BaseActivity<MainViewModel, ActivityMainBinding>(), HasSupportFragmentInjector
{
    override val viewModel: MainViewModel by getLazyViewModel()
    override val layoutId: Int get() = R.layout.activity_main

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector


    override fun onViewInitiailized(binding: ActivityMainBinding) {
        binding.viewModel = viewModel
        viewModel.openHomePage()
    }
}