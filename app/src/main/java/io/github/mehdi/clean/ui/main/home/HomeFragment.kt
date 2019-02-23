package io.github.mehdi.clean.ui.main.home

import android.os.Bundle
import android.view.View
import io.github.mehdi.clean.R
import io.github.mehdi.clean.databinding.FragmentHomeBinding
import io.github.mehdi.clean.ui.base.BaseFragment
import io.github.mehdi.presentation.presenters.base.ViewModelScope
import io.github.mehdi.presentation.presenters.main.home.HomeViewModel

class HomeFragment: BaseFragment<HomeViewModel, FragmentHomeBinding>()
{
    companion object {
        fun newInstance() = HomeFragment()
    }

    override val viewModel: HomeViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
    }
}