package com.meier.marina.base

import androidx.recyclerview.widget.DiffUtil

open class DiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem?.hashCode() == newItem?.hashCode()
}
