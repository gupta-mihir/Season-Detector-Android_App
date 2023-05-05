package com.example.navigation_graph_app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.navigation_graph_app.databinding.FragmentDataBinding
import com.example.navigation_graph_app.ui.main.SharedViewModel
import kotlin.properties.Delegates


class DataFragment : Fragment() {
    private lateinit var binding : FragmentDataBinding
    //var str_temp :String? = ""
    private val sharedViewModel:SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDataBinding.inflate(inflater,container, false)

        sharedViewModel.season.observe(viewLifecycleOwner) { season ->
            binding.tVMonthNum.text = season
            //this assigns season name to var depending on the month
            var monthSeasonValue: String = when(binding.tVMonthNum.text){
                "0" -> "Winter"
                "1" -> "Winter"
                "2" -> "Spring"
                "3" -> "Spring"
                "4" -> "Spring"
                "5" -> "Summer"
                "6" -> "Summer"
                "7" -> "Summer"
                "8" -> "Fall"
                "9" -> "Fall"
                "10" -> "Fall"
                else ->{
                    "Winter"
                }
            }
            binding.tVSeason.text = monthSeasonValue
            //binding.tVSeason.text = str_temp
            //Assigns value for image view, based on the season name
            var seasonVal: Int = when (binding.tVSeason.text){
                "Winter" -> 2
                "Fall" -> 1
                "Spring" -> 3
                else ->{
                    4
                }
            }
            //assigns an image to the image view based on the season value
            when (seasonVal){
                1 -> binding.iVSeason.setImageResource(R.drawable.season1)
                2 -> binding.iVSeason.setImageResource(R.drawable.season2)
                3 -> binding.iVSeason.setImageResource(R.drawable.season3)
                else->{
                    binding.iVSeason.setImageResource(R.drawable.season4)
                }
            }

        }
        //sharedViewModel.season.observe(viewLifecycleOwner) { season ->
        //    str_temp = season.toString()

        //}




        val view = inflater.inflate(R.layout.fragment_data, container, false)
        //val button = view.findViewById<Button>(R.id.btn_goToMainFrag)


        var monthSeasonValue: String = when(binding.tVMonthNum.text){
            "0" -> "Winter"
            "1" -> "Winter"
            "2" -> "Spring"
            "3" -> "Spring"
            "4" -> "Spring"
            "5" -> "Summer"
            "6" -> "Summer"
            "7" -> "Summer"
            "8" -> "Fall"
            "9" -> "Fall"
            "10" -> "Fall"
            else ->{
                "Winter"
            }
        }
        binding.tVSeason.text = binding.tVMonthNum.text
        //binding.tVSeason.text = str_temp

        var seasonVal: Int = when (binding.tVSeason.text){
            "Winter" -> 2
            "Fall" -> 1
            "Spring" -> 3
            else ->{
                4
            }
        }
        when (seasonVal){
            1 -> binding.iVSeason.setImageResource(R.drawable.season1)
            2 -> binding.iVSeason.setImageResource(R.drawable.season2)
            3 -> binding.iVSeason.setImageResource(R.drawable.season3)
            else->{
                binding.iVSeason.setImageResource(R.drawable.season4)
            }
        }
        binding.btnGoToMainFrag.setOnClickListener {
            sharedViewModel.saveSeason(binding.tVMonthNum.text.toString())
            findNavController().navigate(R.id.action_dataFragment_to_mainFragment)
        }


        return binding.root
    }



}