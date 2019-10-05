package com.example.latihanapi.adapters

import android.content.Context
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanapi.R
import com.example.latihanapi.models.ModelProduct
import com.example.latihanapi.utils.ApiClient
import com.squareup.picasso.Picasso

class MainAdapter(val context: Context, val products: ArrayList<ModelProduct>) :
    RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main, null)
        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val product = products.get(position)
        holder.tv1.text = product.productName
        holder.tv2.text = product.branch.branchName
        e("image$position", product.image)
        Picasso.get()
            .load("${ApiClient.IMAGE_URL}${product.image}")
            .into(holder.imglist)
    }

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imglist: ImageView
        val tv1: TextView
        val tv2: TextView

        init {
            imglist = view.findViewById(R.id.imglist)
            tv1 = view.findViewById(R.id.tv1)
            tv2 = view.findViewById(R.id.tv2)
        }
    }
}