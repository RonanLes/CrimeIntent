package com.example.crimeintent

import androidx.lifecycle.ViewModel
import java.util.*
class CrimeListViewModel: ViewModel(){
    val incidents = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            val incident = Crime(
            id = UUID.randomUUID(),
            titre = "Crime #$i",
            date = Date(),
            estResolu = i % 2 == 0
            )
            incidents += incident
        }
    }
}