package com.example.testfragment.features.exercises.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testfragment.features.exercises.databinding.FragmentExercisesBinding
import com.example.testfragment.features.exercises.presentation.ExercisesState
import com.example.testfragment.features.exercises.presentation.ExercisesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExercisesFragment : Fragment() {
    companion object {
        fun newInstance(): ExercisesFragment =
            ExercisesFragment()
    }

    private lateinit var binding: FragmentExercisesBinding
    private val viewModel: ExercisesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExercisesBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        viewModel.getExercise()
    }

    private fun setObservers() {
        viewModel.state.observe(viewLifecycleOwner, ::handleState)
    }

    private fun handleState(state: ExercisesState) {
        when(state) {
            is ExercisesState.Content -> renderContent(state)
            else -> renderLoading()
        }
    }

    private fun renderContent(state: ExercisesState.Content) {
        with(binding) {
            progressBar.visibility = View.GONE
            textView.visibility = View.VISIBLE

            textView.text = state.exerciseName
        }
    }

    private fun renderLoading() {
        with(binding) {
            progressBar.visibility = View.VISIBLE
            textView.visibility = View.GONE
        }
    }
}