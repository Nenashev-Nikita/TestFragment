package com.example.testfragment.presentation.fragments

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.testfragment.presentation.DataModel
import com.example.testfragment.contract.navigator
import com.example.testfragment.databinding.FragmentMainBinding
import java.text.DateFormat
import java.util.*

class MainFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var  binding: FragmentMainBinding

    private val ct: String? = DateFormat.getDateInstance().format(Date())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_workout, container, false)
        binding = FragmentMainBinding.inflate(inflater)
        DataText()
        return binding.root
    }

    /**
     * 27-32 когда работает pager2
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /*binding.floatingActionButton.setOnClickListener {
            onStartNewWorkoutFragment()
        }*/

        binding.meny.buttonTraining.setOnClickListener{
            onStartTrainingFragment()
        }
        binding.meny.buttonTrain.setOnClickListener{
            onStartTrainFragment()
        }
    }

    private fun onStartTrainingFragment() {
        navigator().startTrainingFragment()
    }
    private fun onStartTrainFragment() {
        navigator().startTrainFragment()
    }
    private fun DataText(){
        val ourFontsize = 24f
        binding.data.dataTextView.text = ct
        binding.data.dataTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontsize)
    }
    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}