package com.example.navigation_graph_app.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.navigation_graph_app.R
import com.example.navigation_graph_app.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    lateinit var calendarView: CalendarView
    lateinit var message:TextView

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        binding = FragmentMainBinding.inflate(inflater,container, false)

        sharedViewModel.season.observe(viewLifecycleOwner) { season ->
            binding.tvMonthS.text = season
        }


        var monthSeason = 0
        binding.calendarView.setOnDateChangeListener(
            CalendarView.OnDateChangeListener { calendarView,year, month, dayOfMonth ->
                val Date = (dayOfMonth.toString() + "-"
                        + (month + 1) + "-" + year)

                binding.tvMonthS.text = month.toString()
                binding.message.text = Date
            })


        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val button = view.findViewById<Button>(R.id.btn_gotodata)
        //this button changes fragments and sends data to the ViewModel
        binding.btnGotodata.setOnClickListener{
            sharedViewModel.saveSeason(binding.tvMonthS.text.toString())
            findNavController().navigate(R.id.action_mainFragment_to_dataFragment)
        }



        return binding.root
    }

}