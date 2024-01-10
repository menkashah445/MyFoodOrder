package com.menkashah.foodorder.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.menkashah.foodorder.databinding.FragmentMenuBottomSheetBinding
import com.menkashah.foodorder.databinding.MenuItemBinding

class menuAdapter(private val MenuItem : MutableList<String>, private val MenuItemPrice: MutableList<String>, private val MenuImage: MutableList<Int>) : RecyclerView.Adapter<menuAdapter.MyMenuHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuAdapter.MyMenuHolder {

        return MyMenuHolder(MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: menuAdapter.MyMenuHolder, position: Int) {
        holder.menuBind(position)


    }

    override fun getItemCount(): Int {
        return MenuItem.size
    }

    inner class MyMenuHolder(private val binding: MenuItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun menuBind(position: Int) {
            binding.apply {
                menuName.text = MenuItem[position]
                menuPrice.text = MenuItemPrice[position]
                menuImage.setImageResource(MenuImage[position])
            }

        }
    }



}