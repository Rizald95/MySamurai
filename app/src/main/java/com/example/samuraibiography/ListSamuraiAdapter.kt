package com.example.samuraibiography

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListSamuraiAdapter(private val listSamurai: ArrayList<Samurai>) : RecyclerView.Adapter<ListSamuraiAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val textSamurai: TextView = itemView.findViewById(R.id.text_name_samurai)
        val descriptionSamurai: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_samurai, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSamurai.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listSamurai[position]
        holder.imgPhoto.setImageResource(photo)
        holder.textSamurai.text = name
        holder.descriptionSamurai.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listSamurai[holder.adapterPosition])
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.IMG, photo)
            intent.putExtra(DetailActivity.NAME, name)
            intent.putExtra(DetailActivity.DESCRIPTION, description)
            holder.itemView.context.startActivity(intent)

        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Samurai)
    }

}