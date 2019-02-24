package io.github.mehdi.clean.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import io.github.mehdi.clean.R
import io.github.mehdi.clean.databinding.FragmentHomeBinding
import io.github.mehdi.clean.databinding.ItemCountryBinding
import io.github.mehdi.clean.ui.base.BaseFragment
import io.github.mehdi.clean.ui.base.adapter.BaseAdapter
import io.github.mehdi.domain.model.DomainCountryModel
import io.github.mehdi.presentation.presenters.base.ViewModelScope
import io.github.mehdi.presentation.presenters.main.home.HomeViewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    companion object {
        fun newInstance() = HomeFragment()
    }

    override val viewModel: HomeViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int get() = R.layout.fragment_home


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel

        subscribeToLiveData()
        viewModel.getCountryList()
    }

    private fun subscribeToLiveData() {
        viewModel.countryListLiveData.observe(this, Observer {

            binding.adapter = BaseAdapter<DomainCountryModel, ItemCountryBinding>(
                R.layout.item_country,
                BR.item,
                it,
                BR.viewModel,
                viewModel
            )
        })
    }
}