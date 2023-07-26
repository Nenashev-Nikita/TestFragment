package com.example.testfragment.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.testfragment.presentation.DataModel
import com.example.testfragment.contract.navigator
import com.example.testfragment.databinding.FragmentTrainingBinding


class TrainingFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var  binding: FragmentTrainingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.nameActivityTraining.observe(activity as LifecycleOwner) {
            binding.main.text = "Список тренировок"
        }
        binding.floatingActionButton.setOnClickListener {
            //NewCreatButton()
            onStartNewTrainingFragment()
        }

        binding.nog.setOnClickListener {
            onStartWorkoutFragment()
        }
        /*binding.meny.buttonMeny.setOnClickListener {
            onStartMainFragment()
        }
        binding.meny.buttonTrain.setOnClickListener {
            onStartTrainFragment()
        }*/

    }
    private fun NewCreatButton() {
        val dynamicButton = Button(context)
        dynamicButton.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        dynamicButton.text = "fsdgs"
        binding.listbutton.addView(dynamicButton)
        }



    private fun onStartNewTrainingFragment() {
        navigator().startNewTrainingFragment()
    }

    private fun onStartWorkoutFragment(){
        navigator().startWorkoutFragment()
    }

    private fun onStartMainFragment() {
        navigator().startMainFragment()
    }
    private fun onStartTrainFragment(){
        navigator().startTrainFragment()
    }

    companion object {
        @JvmStatic
        fun newInstance() = TrainingFragment()
    }
}