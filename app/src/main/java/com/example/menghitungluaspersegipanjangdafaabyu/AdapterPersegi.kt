package com.example.menghitungluaspersegipanjangdafaabyu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPersegi (private val persegi : ArrayList<Dataangka>) :
        RecyclerView.Adapter<AdapterPersegi.viewHolder>() {
    class viewHolder (view: View) : RecyclerView.ViewHolder(view){
        val hasil = view.findViewById<TextView>(R.id.id_hasil)
        val hapus = view.findViewById<ImageView>(R.id.hapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_adapter_persegi,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = persegi[position]
        holder.hasil.text = data.hasil.toString()
        holder.hapus.setOnClickListener {
            persegi.removeAt(position)
            notifyItemRangeRemoved(position,persegi.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = persegi.size
}