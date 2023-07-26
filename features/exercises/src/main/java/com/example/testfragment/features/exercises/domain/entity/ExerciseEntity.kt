package com.example.testfragment.features.exercises.domain.entity

data class ExerciseEntity(
    val name: String,
    val type: String,
    val muscle: String,
    val equipment: String,
    val difficulty: String,
    val instructions: String,
)
