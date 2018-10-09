package com.meier.marina.editor

import android.os.Parcelable
import androidx.annotation.IntDef
import kotlinx.android.parcel.Parcelize

const val KEY_EDITOR_CONFIG = "KEY_EDITOR_CONFIG"

const val CREATE = 0
const val EDIT = 1

@IntDef(CREATE, EDIT)
@Retention(AnnotationRetention.RUNTIME)
annotation class Type

@Parcelize
data class EditorConfig(@Type val type: Int) : Parcelable