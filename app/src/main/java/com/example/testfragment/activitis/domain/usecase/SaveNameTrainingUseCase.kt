package com.example.testfragment.activitis.domain.usecase

import com.example.testfragment.activitis.domain.models.SaveParamNameTraining

class SaveNameTrainingUseCase {

    fun execute(param: SaveParamNameTraining) : Boolean{
        if(param.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}