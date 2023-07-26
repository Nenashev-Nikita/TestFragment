package com.example.testfragment.features.exercises.data.repository

import com.example.testfragment.features.exercises.data.datasource.ExercisesDataSource
import com.example.testfragment.features.exercises.data.mapper.toEntity
import com.example.testfragment.features.exercises.domain.entity.ExerciseEntity
import com.example.testfragment.features.exercises.domain.repository.ExercisesRepository

class ExercisesRepositoryImpl(private val exercisesDataSource: ExercisesDataSource) : ExercisesRepository {
    override suspend fun getExercises(muscle: String): List<ExerciseEntity> =
        exercisesDataSource.getExercises(muscle).toEntity()
}