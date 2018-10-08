package com.meier.marina.base.exteptions

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(@StringRes res: Int) = Toast.makeText(this, res, Toast.LENGTH_SHORT).show()