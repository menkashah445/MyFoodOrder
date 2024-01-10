package com.menkashah.foodorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.menkashah.foodorder.Adapter.menuAdapter
import com.menkashah.foodorder.databinding.FragmentMenuBottomSheetBinding


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)


        binding.btnBack.setOnClickListener{
            dismiss()
        }
        val MenufoodName = listOf(
            "Burger",
            "Momos",
            "Sandwitch",
            "Chilli",
            "Bread",
            "Dal",
            "Roti",
            "Rice",
            "Panner",
            "Maggie"
        )
        val MenufoodPrice = listOf("$5", "$4", "$7", "$10", "$2", "$5", "$4", "$7", "$10", "$2")
        val MenufoodImage = listOf(
            R.drawable.banner0,
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner9,
            R.drawable.banner4,
            R.drawable.banner5,
            R.drawable.banner16,
            R.drawable.banner7,
            R.drawable.banner8,
            R.drawable.banner0
        )

        //        add adapter class
        val adapter = menuAdapter(
            ArrayList(MenufoodName),
            ArrayList(MenufoodPrice),
            ArrayList(MenufoodImage)
        )
        binding.menuRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecycleView.adapter = adapter
         return  binding.root
    }
    companion object {

        }

    }
