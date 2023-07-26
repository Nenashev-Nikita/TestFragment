package com.example.testfragment.features.exercises.domain.usecase

import com.example.testfragment.features.exercises.domain.entity.ExerciseEntity
import com.example.testfragment.features.exercises.domain.repository.ExercisesRepository

class GetExercisesUseCase(private val exercisesRepository: ExercisesRepository) {
    suspend operator fun invoke(muscle: String): List<ExerciseEntity> =
        exercisesRepository.getExercises(muscle)
}