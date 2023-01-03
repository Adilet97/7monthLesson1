package com.example.a7monthlesson1.domain.model

data class Note (
    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String,
    val createAt: Long
        ){
    companion object{
        const val DEFAULT_ID = 0
    }
}