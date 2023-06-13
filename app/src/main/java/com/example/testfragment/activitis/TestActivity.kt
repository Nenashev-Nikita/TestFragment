package com.example.testfragment.activitis

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testfragment.R
import com.example.testfragment.activitis.contract.Navigator
import com.example.testfragment.activitis.fragments.*
import com.example.testfragment.databinding.ActivityMainBinding
import java.text.DateFormat
import java.util.*

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

    override fun showTrainingFragment() {
        openFrag(TrainingFragment.newInstance(), R.id.start_fragment)
    }
    override fun showWorkoutFragment() {
        openFrag(WorkoutFragment.newInstance(), R.id.start_fragment)
    }

    override fun showNewWorkoutFragment(){
        openFrag(NewWorkoutFragment.newInstance(), R.id.start_fragment)
    }

    override fun showMainFragment(){
        openFrag(MainFragment.newInstance(), R.id.start_fragment)
    }
    override fun showNewTrainingFragment(){
        openFrag(NewTrainingFragment.newInstance(), R.id.start_fragment)
    }

    override fun goBack() {

    }
    override fun goToMenu() {

    }
}
