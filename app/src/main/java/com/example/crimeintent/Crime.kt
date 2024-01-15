package com.example.crimeintent

import java.util.Date
import java.util.UUID

data class Crime(
    val id: UUID,
    val titre:String,
    val date: Date,
    val estResolu:Boolean
)
