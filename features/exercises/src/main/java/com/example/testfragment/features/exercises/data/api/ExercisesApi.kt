package com.example.testfragment.features.exercises.data.api

import com.example.testfragment.features.exercises.data.dto.ExerciseDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ExercisesApi {
    @Headers(
        "X-Api-Key: 5Jo2ECFCeqIiH34p6/YAFg==SLZ7boyWqSDovZ3P"
    )
    @GET("exercises")
    suspend fun getExercises(@Query("muscle") muscle: String): List<ExerciseDTO>
}