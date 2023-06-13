package com.example.testfragment.activitis.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.testfragment.activitis.DataModel
import com.example.testfragment.activitis.contract.navigator
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

        binding.meny.buttonMeny.setOnClickListener{
            onStartMainFragment()
        }

        binding.nog.setOnClickListener {
            onStartWorkoutFragment()
        }

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
        navigator().showNewTrainingFragment()
    }

    private fun onStartWorkoutFragment(){
        navigator().showWorkoutFragment()
    }

    private fun onStartMainFragment() {
        navigator().showMainFragment()
    }

    companion object {
        @JvmStatic
        fun newInstance() = TrainingFragment()
    }
}