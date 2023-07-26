package com.example.testfragment.features.exercises.domain.repository

import com.example.testfragment.features.exercises.domain.entity.ExerciseEntity

interface ExercisesRepository {
    suspend fun getExercises(muscle: String): List<ExerciseEntity>
}