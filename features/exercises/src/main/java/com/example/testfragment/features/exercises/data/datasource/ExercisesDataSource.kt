package com.example.testfragment.features.exercises.data.datasource

import com.example.testfragment.features.exercises.data.dto.ExerciseDTO

interface ExercisesDataSource {
    suspend fun getExercises(muscle: String): List<ExerciseDTO>
}