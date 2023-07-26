package com.example.testfragment.features.exercises.data.datasource

import com.example.testfragment.features.exercises.data.api.ExercisesApi
import com.example.testfragment.features.exercises.data.dto.ExerciseDTO

class ExercisesDataSourceImpl(private val exercisesApi: ExercisesApi) : ExercisesDataSource {
    override suspend fun getExercises(muscle: String): List<ExerciseDTO> =
        exercisesApi.getExercises(muscle)
}