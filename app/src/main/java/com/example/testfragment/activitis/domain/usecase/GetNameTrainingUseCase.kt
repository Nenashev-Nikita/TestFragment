package com.example.testfragment.activitis.domain.usecase

import com.example.testfragment.activitis.domain.models.NameTraining

class GetNameTrainingUseCase {

    fun execute(): NameTraining{
        return NameTraining(firstName = "defolt")
    }
}