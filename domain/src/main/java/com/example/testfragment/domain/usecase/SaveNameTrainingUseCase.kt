package com.example.testfragment.domain.usecase

import com.example.testfragment.domain.models.SaveParamNameTraining
import com.example.testfragment.domain.repository.NameRepository

class SaveNameTrainingUseCase(private val nameRepository: NameRepository) {

    fun execute(param: SaveParamNameTraining): Boolean {
        val oldName = nameRepository.getName()
        if (oldName.firstName == param.name){
            return true
        }
        return nameRepository.saveName(saveParam = param)
    }
}