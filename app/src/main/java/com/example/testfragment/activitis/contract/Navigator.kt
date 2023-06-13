package com.example.testfragment.activitis.contract


import androidx.fragment.app.Fragment


fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun showTrainingFragment()

    fun showWorkoutFragment()

    fun showNewWorkoutFragment()

    fun showNewTrainingFragment()

    fun showMainFragment()

    fun goBack()

    fun goToMenu()


}