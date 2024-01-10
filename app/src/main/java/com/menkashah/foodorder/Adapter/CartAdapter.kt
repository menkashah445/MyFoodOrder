package com.menkashah.foodorder.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.menkashah.foodorder.databinding.CartItemBinding

class CartAdapter(private val cartItems:MutableList<String>, private val cartitemPrice: MutableList<String>, private val CartImage:MutableList<Int>): RecyclerView.Adapter<CartAdapter.MyCartHolder>() {

   private val itemQuantati = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.MyCartHolder {
        return MyCartHolder(CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CartAdapter.MyCartHolder, position: Int) {
//        val cartItem = cartItems[position]
//        val cartitemPrice =cartitemPrice[position]
//        val cartImage = cartImage[position]
//        holder.CartBind(cartItem,cartitemPrice,cartImage)
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return  cartItems.size
    }

    inner class MyCartHolder(private val binding: CartItemBinding): RecyclerView.ViewHolder(binding.root){
//         private val CartImageView = binding.cartImage
//
//        fun CartBind(cartItem: String, cartitemPrice: String, cartImage: Int){
//            binding.CartFoodname.text= cartItem
//            binding.Cartdoalrprice.text= cartitemPrice
//            CartImageView.setImageResource(cartImage)

        fun bind(position: Int){
            binding.apply {
                val quantity = itemQuantati[position]
                CartFoodname.text = cartItems[position]
                Cartdoalrprice.text = cartitemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuantity.text = quantity.toString()
            }

        }



        }

    }

