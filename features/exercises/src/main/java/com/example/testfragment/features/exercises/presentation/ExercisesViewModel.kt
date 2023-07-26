package com.example.testfragment.features.exercises.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testfragment.features.exercises.domain.usecase.GetExercisesUseCase
import kotlinx.coroutines.launch

class ExercisesViewModel(
    private val getExercisesUseCase: GetExercisesUseCase,
) : ViewModel() {
    private val _state: MutableLiveData<ExercisesState> = MutableLiveData(ExercisesState.Loading)
    val state: LiveData<ExercisesState> = _state

    fun getExercise() {
        viewModelScope.launch {
            val exercise = getExercisesUseCase("biceps")[0].name
            _state.value = ExercisesState.Content(exerciseName = exercise)
        }
    }
}