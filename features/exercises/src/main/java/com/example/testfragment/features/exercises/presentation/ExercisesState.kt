package com.example.testfragment.features.exercises.presentation

sealed class ExercisesState {
    object Loading : ExercisesState()
    data class Content(
        val exerciseName: String
    ) : ExercisesState()
}
