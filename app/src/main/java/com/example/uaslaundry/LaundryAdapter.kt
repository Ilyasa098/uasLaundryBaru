package com.example.uaslaundry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LaundryAdapter(val list: List<LaundryModel>,val konteks: Context,val viewModel: PembayaranViewModel): RecyclerView.Adapter<LaundryAdapter.LaundryViewHolder>() {

    class LaundryViewHolder(baris: View):RecyclerView.ViewHolder(baris){
        val gambarBaju=baris.findViewById<ImageView>(R.id.ivGambarBaju)
        val tvnamaBaju=baris.findViewById<TextView>(R.id.tvNamaBaju)
        val tvhargaBaju=baris.findViewById<TextView>(R.id.tvHargaBaju)
        val tvcounter=baris.findViewById<TextView>(R.id.tvCounterBaju)
        val tvbuttonTambah=baris.findViewById<Button>(R.id.btnTambah)
        val tvbuttonKurang=baris.findViewById<Button>(R.id.btnKurang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaundryViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.layout_recyler_laundry,parent,false)
        return  LaundryViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LaundryViewHolder, position: Int) {
        val bind = list[position]

        holder.tvnamaBaju.text = bind.namaBaju
        holder.tvhargaBaju.text = bind.hargaLaundry.toString()
        holder.tvcounter.text = bind.counter.toString()

        Glide.with(konteks).load(bind.gambar).placeholder(R.drawable.ic_kaos).into(holder.gambarBaju)

        holder.tvbuttonTambah.setOnClickListener {
            bind.counter+=1
            notifyDataSetChanged()
            viewModel.setTotalHarga()
        }
        holder.tvbuttonKurang.setOnClickListener {
            if (bind.counter <= 0){
                Toast.makeText(konteks, "Wes Minus", Toast.LENGTH_SHORT).show()
            }else{
                bind.counter-=1
                notifyDataSetChanged()
                viewModel.setTotalHarga()

            }

        }
    }
}