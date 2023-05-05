package com.example.navigation_graph_app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigation_graph_app.R

class SharedViewModel: ViewModel() {
    private var _season = MutableLiveData("0")
    //private var _seasonName = MutableLiveData("")

    val season:LiveData<String> = _season

   // val seasonName: String = ""
    fun saveSeason(newSeason: String){
        _season.value = newSeason
    }
    //Logic to check the season name based on the the season value
    var seasonName : String = when(_season.value){
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
    //logic to check the season value based on the name, for the imageview
    var seasonValVM: Int = when (seasonName){
        "Winter" -> 2
        "Fall" -> 1
        "Spring" -> 3
        else ->{
            4
        }
    }


}