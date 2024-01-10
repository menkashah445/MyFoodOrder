package com.menkashah.foodorder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.menkashah.foodorder.Adapter.PopularAdapter
import com.menkashah.foodorder.MenuBottomSheetFragment
import com.menkashah.foodorder.R
import com.menkashah.foodorder.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private  lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentHomeBinding.inflate(inflater, container, false)

         binding.viewMenu.setOnClickListener{
             val BottomSheetDialog = MenuBottomSheetFragment()
             BottomSheetDialog.show(parentFragmentManager,"task")

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.banner0, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner0, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner8, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner5, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner16, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner7, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner8, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner9, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here.
                val itemPosition = imageList[position]
                val itemMessage = "Selected images $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()

            }
            override fun doubleClick(position: Int) {
                // Do not use onItemSelected if you are using a double click listener at the same time.
                // Its just added for specific cases.
                // Listen for clicks under 250 milliseconds.
            }
        })

        val foodName = listOf("Burger","Momos","Sandwitch","Chilli","Bread","Dal", "Roti","Rice","Panner","Maggie")
        val foodPrice = listOf("$5","$4","$7","$10","$2","$5","$4","$7","$10","$2")
        val foodImage = listOf(R.drawable.banner0,
            R.drawable.banner1,R.drawable.banner2,R.drawable.banner9,R.drawable.banner4,
            R.drawable.banner5,R.drawable.banner16,R.drawable.banner7,R.drawable.banner8,R.drawable.banner0,)

//        add adapter class
        val adapter = PopularAdapter(foodName,foodPrice,foodImage)
        binding.PopularrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularrecyclerView.adapter= adapter
    }


    companion object{

    }


}