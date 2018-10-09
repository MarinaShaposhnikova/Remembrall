package com.meier.marina.editor.listapp

import android.content.pm.ResolveInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meier.marina.editor.R
import kotlinx.android.synthetic.main.item_app.view.*

class ListAppAdapter(private val apps: List<ResolveInfo>) :
    RecyclerView.Adapter<ListAppAdapter.ListAppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListAppAdapter.ListAppViewHolder {
        return ListAppViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_app, parent, false))
    }

    override fun onBindViewHolder(holder: ListAppViewHolder, position: Int) {
        with(holder) {
            val item = apps[position]
            itemView.imageIcon.context.packageManager.apply {
                itemView.textName.text = item.activityInfo.loadLabel(this)
                itemView.imageIcon.setImageDrawable(item.activityInfo.loadIcon(this))
            }
        }
    }

    override fun getItemCount() = apps.size

    inner class ListAppViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
