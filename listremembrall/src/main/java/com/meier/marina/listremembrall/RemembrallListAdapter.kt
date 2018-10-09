package com.meier.marina.listremembrall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.RecyclerView
import com.meier.marina.data.entity.Remembrall
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_remembrall.*

internal class RemembrallListAdapter(
    listConfig: AsyncDifferConfig<Remembrall>
) : PagedListAdapter<Remembrall, RemembrallListAdapter.RemembrallViewHolder>(listConfig) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemembrallViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_remembrall, parent, false)
        return RemembrallViewHolder(view)
    }

    override fun onBindViewHolder(holder: RemembrallViewHolder, position: Int) {
        //TODO: implementation for placeholders
        with(holder) {
            val item = getItem(position) ?: return
            textName.text = item.name
        }
    }

    internal class RemembrallViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
}
