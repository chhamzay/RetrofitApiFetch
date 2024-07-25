package com.example.retrofiltsapi.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofiltsapi.ApiDataItem
import com.example.retrofiltsapi.MyData
import com.example.retrofiltsapi.MyDataItem
import com.example.retrofiltsapi.databinding.ProductItemBinding
import com.squareup.picasso.Picasso

class ProductAdapter(private val products:List<ApiDataItem>) :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding=ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
      holder.bind(position)
    }

    override fun getItemCount(): Int {
        return products.size
    }

   inner class ProductViewHolder(val binding:ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                producttitle.text = products[position].category
                Picasso.get().load(products[position].image).into(productImage)
            }
        }


    }
}