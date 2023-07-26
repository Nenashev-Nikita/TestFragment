package com.example.testfragment.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testfragment.contract.navigator
import com.example.testfragment.databinding.FragmentNewTrainBinding

class NewTrainFragment : Fragment() {

    lateinit var binding: FragmentNewTrainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTrainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            binding.buttonAdd.setOnClickListener {
                onStartWorkoutfragment()
            }
    }

    private fun onStartWorkoutfragment(){
        navigator().startWorkoutFragment()
    }
    companion object {
        @JvmStatic
        fun newInstance() = NewTrainFragment()
    }
}