package com.menkashah.foodorder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.menkashah.foodorder.Adapter.CartAdapter
import com.menkashah.foodorder.Adapter.PopularAdapter
import com.menkashah.foodorder.R
import com.menkashah.foodorder.databinding.FragmentCartBinding



class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)


    val CartfoodName = listOf("Burger","Momos","Sandwitch","Chilli","Bread","Dal", "Roti","Rice","Panner","Maggie")
    val CartfoodPrice = listOf("$5","$4","$7","$10","$2","$5","$4","$7","$10","$2")
    val CartfoodImage = listOf(R.drawable.banner0,
        R.drawable.banner1,R.drawable.banner2,R.drawable.banner9,R.drawable.banner4,
        R.drawable.banner5,R.drawable.banner16,R.drawable.banner7,R.drawable.banner8,R.drawable.banner0)

    //        add adapter class
        val adapter = CartAdapter(ArrayList(CartfoodName),ArrayList(CartfoodPrice),ArrayList(CartfoodImage))
        binding.CartrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.CartrecyclerView.adapter= adapter
        return  binding.root
    }

    companion object {

    }
}