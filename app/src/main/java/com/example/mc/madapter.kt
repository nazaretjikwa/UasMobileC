package com.example.mc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class madapter (var mContext: Context, var filmList: List<DataFilm>):

    RecyclerView.Adapter<madapter.ListViewHolder>() {

    inner class ListViewHolder(var v: View) : RecyclerView.ViewHolder(v) {

        val imgTT = v.findViewById<ImageView>(R.id.imgFilm)

        val judulTT = v.findViewById<TextView>(R.id.jdl)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): madapter.ListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var v = inflater.inflate(R.layout.hm, parent, false)
        return ListViewHolder(v)
    }

    override fun onBindViewHolder(holder: madapter.ListViewHolder, position: Int) {
        val newList = filmList[position]
        holder.imgTT.loadImage(newList.imgUrl)
        holder.judulTT.text = newList.judul
        holder.v.setOnClickListener {

            val actor = newList.Actor
            val direktor = newList.Drirector
            val gendre = newList.Gendre
            val sinopcis = newList.Synopsice
            val judul = newList.judul
            val img = newList.imgUrl

            val mIntent = Intent(mContext, Deskripsi::class.java)
            mIntent.putExtra("ACTOR", actor)
            mIntent.putExtra("DIRECTOR", direktor)
            mIntent.putExtra("GENDRE", gendre)
            mIntent.putExtra("SYNOPSCISE", sinopcis)
            mIntent.putExtra("JUDUL", judul)
            mIntent.putExtra("IMAGE", img)

            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return filmList.size
    }


}