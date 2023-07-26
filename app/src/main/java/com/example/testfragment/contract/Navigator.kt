package com.example.testfragment.contract


import androidx.fragment.app.Fragment


fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun startTrainingFragment()

    fun startWorkoutFragment()

    fun startNewWorkoutFragment()

    fun startNewTrainingFragment()

    fun startMainFragment()

    fun goBack()

    fun goToMenu()

    fun startExercisesFragment()

    fun startNewTrainFragment()

    fun startTrainFragment()
}