package com.meier.marina.base

import android.view.View
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import com.meier.marina.base.exteptions.showToast

sealed class State {
    class Error(@StringRes val res: Int) : State()
    object Loading : State()
    object Success : State()
}

fun baseStateObserver(progress: View): Observer<State> {
    return Observer {
        when (it) {
            is State.Error -> {
                progress.visibility = View.GONE
                progress.context.showToast(it.res)
            }
            is State.Success -> {
                progress.visibility = View.GONE

            }
            is State.Loading -> {
                progress.visibility = View.VISIBLE
            }
        }
    }
}
