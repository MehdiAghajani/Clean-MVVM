package io.github.MehdiAghajani.presentation.util.livedata

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

typealias ActivityAction = (FragmentActivity) -> Unit

class ActivityActionLiveData: SingleEventLiveData<ActivityAction>() {

    operator fun invoke(action: ActivityAction) {
        this.value = action
    }
}


typealias FragmentAction = (Fragment) -> Unit

class FragmentActionLiveData: SingleEventLiveData<FragmentAction>() {
    operator fun invoke(action: FragmentAction) {
        this.value = action
    }
}

typealias DialogFragmentAction = (DialogFragment) -> Unit

class DialogFragmentActionLiveData: SingleEventLiveData<DialogFragmentAction>() {
    operator fun invoke(action: DialogFragmentAction) {
        this.value = action
    }
}