package com.drivemech.Ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drivemech.Data.Overview
import com.drivemech.R

class OverviewAdapter(private val items: List<Overview>) :
    RecyclerView.Adapter<OverviewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon = view.findViewById<ImageView>(R.id.icon)
        val title = view.findViewById<TextView>(R.id.title)
        val count = view.findViewById<TextView>(R.id.count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.overview_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.icon.setImageResource(item.iconRes)
        holder.title.text = item.title
        holder.count.text = item.count
    }
}
