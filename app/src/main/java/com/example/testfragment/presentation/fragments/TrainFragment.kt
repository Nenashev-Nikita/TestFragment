package com.example.testfragment.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testfragment.contract.navigator
import com.example.testfragment.databinding.FragmentTrainBinding

class TrainFragment : Fragment() {
    lateinit var binding: FragmentTrainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.meny.buttonMeny.setOnClickListener {
            onStartMainFragment()
        }
        binding.meny.buttonTraining.setOnClickListener {
            onStartTrainingFragment()
        }
    }
    private fun onStartMainFragment(){
        navigator().startMainFragment()
    }
    private fun onStartTrainingFragment(){
        navigator().startTrainingFragment()
    }
    companion object {
        @JvmStatic
        fun newInstance() = TrainFragment()
    }
}