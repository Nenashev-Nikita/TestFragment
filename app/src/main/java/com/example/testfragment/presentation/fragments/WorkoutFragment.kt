package com.example.testfragment.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.testfragment.R
import com.example.testfragment.presentation.DataModel
import com.example.testfragment.contract.navigator
import com.example.testfragment.databinding.FragmentWorkoutBinding
import java.text.DateFormat
import java.util.*

//const val ARG_OBJECT = "object"

class WorkoutFragment : Fragment() {
    //private val dataModel: DataModel by activityViewModels()
    lateinit var  binding: FragmentWorkoutBinding
    //private val ct: String? = DateFormat.getDateInstance().format(Date())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_workout, container, false)
        binding = FragmentWorkoutBinding.inflate(inflater)
        return binding.root
    }

    /**
     * 27-32 когда работает pager2
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cancel.setOnClickListener {
            onStartTrainingFragment()
        }

        binding.save.setOnClickListener {
            onStartTrainingFragment()
        }
        binding.newWorkout.setOnClickListener {
            onStartNewTrainFragment()
        }
        binding.buttonList.button.setOnClickListener {
            onStartExercisesFragment()
        }
    }

    private fun onStartTrainingFragment() {
        navigator().startTrainingFragment()
    }

    private fun onStartNewTrainFragment() {
        navigator().startNewTrainFragment()
    }
    private fun onStartExercisesFragment() {
        navigator().startExercisesFragment()
    }
    companion object {
        @JvmStatic
        fun newInstance() = WorkoutFragment()
    }
}
