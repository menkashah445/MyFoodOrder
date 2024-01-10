package com.menkashah.foodorder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.menkashah.foodorder.Adapter.menuAdapter
import com.menkashah.foodorder.R
import com.menkashah.foodorder.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: menuAdapter
    private val orignalFoodNameItem= listOf("Burger",
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
     private val SearchCartfoodPrice = listOf("$5","$4","$7","$10","$2","$5","$4","$7","$10","$2")
     private val SearchCartfoodImage = listOf(R.drawable.banner0,
                                                R.drawable.banner1,
                                                 R.drawable.banner2,
                                                 R.drawable.banner9,
                                                 R.drawable.banner4,
                                                R.drawable.banner5,
                                                 R.drawable.banner16,
                                                 R.drawable.banner7,
                                                 R.drawable.banner8,
                                                 R.drawable.banner0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val FilterorignalFoodNameItem = mutableListOf<String>()
    private val FilterSearchCartfoodPrice = mutableListOf<String>()
    private val FilterSearchCartfoodImage = mutableListOf<Int>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentSearchBinding.inflate(inflater,container,false)
        adapter = menuAdapter(FilterorignalFoodNameItem,
            FilterSearchCartfoodPrice, FilterSearchCartfoodImage
        )
        binding.searchItemView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchItemView.adapter=adapter

        setUpSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        FilterSearchCartfoodPrice.clear()
        FilterorignalFoodNameItem.clear()
        FilterSearchCartfoodImage.clear()

        FilterorignalFoodNameItem.addAll(orignalFoodNameItem)
        FilterSearchCartfoodPrice.addAll(SearchCartfoodPrice)
        FilterSearchCartfoodImage.addAll(SearchCartfoodImage)

        adapter.notifyDataSetChanged()


    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItem(query)

                return TODO("Provide the return value")
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }
        })

    }

    private fun filterMenuItem(query: String) {
        FilterSearchCartfoodPrice.clear()
        FilterorignalFoodNameItem.clear()
        FilterSearchCartfoodImage.clear()

        orignalFoodNameItem.forEachIndexed { index, foodName ->
            if(foodName.contains(query,ignoreCase = true)){
                FilterorignalFoodNameItem.add(foodName)
                FilterSearchCartfoodPrice.add(SearchCartfoodPrice[index])
                FilterSearchCartfoodImage.add(SearchCartfoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()


    }


    companion object {


    }
}