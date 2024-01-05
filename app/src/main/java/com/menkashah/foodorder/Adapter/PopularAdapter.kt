package com.menkashah.foodorder.Adapter

import android.provider.MediaStore.Images
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.menkashah.foodorder.databinding.RvFoodSampleBinding

class PopularAdapter(private  val Items : List<String>, private  val price : List<String>, private val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(RvFoodSampleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  Items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val item = Items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)


    }

    class MyViewHolder(private val binding:RvFoodSampleBinding):RecyclerView.ViewHolder(binding.root){
        private  val imageView = binding.imageView2
        fun bind(item:String, price:String,  images:Int){
            binding.Foodname.text = item
            binding.doalrprice.text = price
            imageView.setImageResource(images)

        }

    }
}