package com.example.testfragment.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testfragment.R
import com.example.testfragment.contract.Navigator
import com.example.testfragment.presentation.fragments.MainFragment
import com.example.testfragment.presentation.fragments.NewTrainingFragment
import com.example.testfragment.presentation.fragments.NewWorkoutFragment
import com.example.testfragment.presentation.fragments.TrainingFragment
import com.example.testfragment.presentation.fragments.WorkoutFragment
import com.example.testfragment.databinding.ActivityMainBinding
import com.example.testfragment.presentation.fragments.ExercisesFragment
import com.example.testfragment.presentation.fragments.NewTrainFragment
import com.example.testfragment.presentation.fragments.TrainFragment

class TestActivity : AppCompatActivity(), Navigator {

    //private lateinit var adapter: NumberAdapter
    //private lateinit var viewPager: ViewPager2

    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        /**
         * 26-29 когда работает pager2
         */

        openFrag(MainFragment.newInstance(), R.id.start_fragment)
        /*
        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.ViewPager)
        viewPager.adapter = adapter*/
    /*
        dataModel.nameActivityTraining.observe(this) {
            binding.main.text = it
        }
        dataModel.nameTraining.observe(this) {
            binding.main.text = it
        }
        dataModel.nameWorkout.observe(this) {
            binding.main.text = it
        }
        binding.meny.train.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.start_fragment, TrainingFragment.newInstance())
                .commit()
        }

        binding.meny.buttonMeny.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.start_fragment, WorkoutFragment.newInstance())
                .commit()
        }*/
    }

        private fun openFrag(f: Fragment, idHolder: Int){
            supportFragmentManager
                .beginTransaction()
                .replace(idHolder, f)
                .commit()
        }

    override fun startTrainingFragment() {
        openFrag(TrainingFragment.newInstance(), R.id.start_fragment)
    }
    override fun startWorkoutFragment() {
        openFrag(WorkoutFragment.newInstance(), R.id.start_fragment)
    }

    override fun startNewWorkoutFragment(){
        openFrag(NewWorkoutFragment.newInstance(), R.id.start_fragment)
    }

    override fun startMainFragment(){
        openFrag(MainFragment.newInstance(), R.id.start_fragment)
    }
    override fun startNewTrainingFragment(){
        openFrag(NewTrainingFragment.newInstance(), R.id.start_fragment)
    }

    override fun startExercisesFragment(){
        openFrag(ExercisesFragment.newInstance(), R.id.start_fragment)
    }

    override fun startNewTrainFragment() {
        openFrag(NewTrainFragment.newInstance(), R.id.start_fragment)
    }

    override fun startTrainFragment(){
        openFrag(TrainFragment.newInstance(), R.id.start_fragment)
    }

    override fun goBack() {

    }
    override fun goToMenu() {

    }
}
