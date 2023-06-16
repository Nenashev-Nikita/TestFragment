package com.example.testfragment.domain.usecase

import com.example.testfragment.domain.models.NameTraining
import com.example.testfragment.domain.repository.NameRepository

class GetNameTrainingUseCase(private val nameRepository: NameRepository) {

    fun execute(): NameTraining {
        return nameRepository.getName()
    }
}