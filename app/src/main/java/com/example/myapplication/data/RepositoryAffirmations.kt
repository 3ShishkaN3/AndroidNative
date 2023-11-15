package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.models.Affirmation

class RepositoryAffirmations {
    companion object {
        fun loadAffirmations(): List<Affirmation> {
            return (1..137).map { Affirmation(getResourceId(it)) }
        }

        private fun getResourceId(index: Int): Int {
            return when (index) {
                in 1..137 -> {
                    val resourceName = "affirmation$index"
                    val field = R.string::class.java.getDeclaredField(resourceName)
                    field.getInt(null)
                }
                else -> throw IndexOutOfBoundsException("Index should be between 1 and 137")
            }
        }
    }
}
