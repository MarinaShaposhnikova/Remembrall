package com.meier.marina.base

import android.view.View

abstract class Destination(val view: View)

interface Navigator {
    fun navigate(destination: Destination)
}
