package com.example.completehub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val eventList : ArrayList<EventDisplay>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {

        return eventList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = eventList[position]

        holder.eventname.text = currentitem.eventname
        holder.eventdate.text = currentitem.eventdate
        holder.eventmode.text = currentitem.eventmode
        holder.eventdescription.text = currentitem.eventdescription
        holder.eventlocation.text = currentitem.eventlocation
        holder.eventcoordinator.text = currentitem.eventcoordinator
        holder.eventcontact.text = currentitem.eventcontact

    }

    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        val eventname : TextView = itemView.findViewById(R.id.Eventname)
        val eventdate : TextView = itemView.findViewById(R.id.Eventdate)
        val eventmode : TextView = itemView.findViewById(R.id.Eventmode)
        val eventdescription : TextView = itemView.findViewById(R.id.Eventdescription)
        val eventlocation : TextView = itemView.findViewById(R.id.Eventlocation)
        val eventcoordinator : TextView = itemView.findViewById(R.id.Eventcoordinators)
        val eventcontact : TextView = itemView.findViewById(R.id.Eventcontact)

    }

}