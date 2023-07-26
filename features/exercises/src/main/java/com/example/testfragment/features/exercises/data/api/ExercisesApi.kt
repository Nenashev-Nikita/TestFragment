package com.example.testfragment.features.exercises.data.api

import com.example.testfragment.features.exercises.data.dto.ExerciseDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ExercisesApi {
    @GET("exercises")
    suspend fun getExercises(@Query("muscle") muscle: String): List<ExerciseDTO>
}