package com.example.testfragment.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testfragment.contract.navigator
import com.example.testfragment.databinding.FragmentNewWorkoutBinding

class NewWorkoutFragment : Fragment() {

    lateinit var binding: FragmentNewWorkoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewWorkoutBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*binding.includButton.button.setOnClickListener {
            val keyword = binding.EditName.text.toString()
            val encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.name())
            dataModel.nameActivityTraining.value = encodedKeyword
            onGetTextTraining()

        }
        binding.EditName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                return@setOnEditorActionListener onGetTextTraining()
            }
            return@setOnEditorActionListener false
        }
        */

        binding.cancel.setOnClickListener {
            onBackWorkoutFragment()
        }
        
    }
    private fun onGetTextWorkout(): Boolean{
        val keyword = binding.EditTextNewWorkout.text.toString()
        if (keyword.isBlank()) {
            binding.EditTextNewWorkout.error = "Нет данных"
        }
        return true
    }

    private fun onBackWorkoutFragment(){
        navigator().startMainFragment()
    }


    companion object {
        @JvmStatic
        fun newInstance() = NewWorkoutFragment()
    }
}