package com.example.testfragment.activitis.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testfragment.activitis.TestActivity
class NumberAdapter(){

}
/*
class NumberAdapter(fragment: TestActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 100

    override fun createFragment(position: Int): Fragment {
        val fragment = WorkoutFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1) //порядковый номер его позиции
        }
        return fragment
    }

}*/
