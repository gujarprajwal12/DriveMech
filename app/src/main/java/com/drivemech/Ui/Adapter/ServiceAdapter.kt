package com.drivemech.Ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drivemech.Data.Service
import com.drivemech.R

class ServiceAdapter(private val items: List<Service>) :
    RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orderId = view.findViewById<TextView>(R.id.orderId)
        val name = view.findViewById<TextView>(R.id.customerName)
        val vehicle = view.findViewById<TextView>(R.id.vehicleName)
        val serviceType = view.findViewById<TextView>(R.id.serviceType)
        val dateTime = view.findViewById<TextView>(R.id.serviceTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.orderId.text = "Order ID: ${item.orderId}"
        holder.name.text = item.customerName
        holder.vehicle.text = item.vehicle
        holder.serviceType.text = item.serviceType
        holder.dateTime.text = "${item.date} | ${item.time}"
    }
}
