package com.example.testfragment.activitis.fragments

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.testfragment.R
import com.example.testfragment.activitis.DataModel
import com.example.testfragment.activitis.contract.navigator
import com.example.testfragment.databinding.FragmentWorkoutBinding
import java.text.DateFormat
import java.util.*

//const val ARG_OBJECT = "object"

class WorkoutFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var  binding: FragmentWorkoutBinding

    private val ct: String? = DateFormat.getDateInstance().format(Date())

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


        binding.list.includButton.button.setOnClickListener {
            dataModel.nameTraining.value = "ghd87sfhs"
        }

        binding.list.nog.setOnClickListener {
            //DataText()
        }

        binding.floatingActionButton.setOnClickListener {
            onStartNewWorkoutFragment()
        }

        binding.meny.buttonTrain.setOnClickListener{
            onStartTrainingFragment()
        }

    }

    private fun onStartNewWorkoutFragment() {
        navigator().showNewWorkoutFragment()
    }
    private fun onStartTrainingFragment() {
        navigator().showTrainingFragment()
    }


    companion object {
        @JvmStatic
        fun newInstance() = WorkoutFragment()
    }
}
