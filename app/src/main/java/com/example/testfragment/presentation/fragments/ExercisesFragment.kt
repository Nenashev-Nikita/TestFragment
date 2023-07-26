package com.example.testfragment.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.testfragment.R
import com.example.testfragment.contract.navigator
import com.example.testfragment.databinding.FragmentExercisesBinding

class ExercisesFragment: Fragment() {
    lateinit var binding: FragmentExercisesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExercisesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.ButtonCount.buttonPlus.setOnClickListener {
            NewCreatApproach()
        }
    }
    private fun NewCreatApproach() {
        /*val dynamicButton = Button(context)
        dynamicButton.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        dynamicButton.text = "fsdgs"*/

    }
    private fun onBack(){
        navigator().goBack()
    }
    companion object {
        @JvmStatic
        fun newInstance() = ExercisesFragment()
    }
}