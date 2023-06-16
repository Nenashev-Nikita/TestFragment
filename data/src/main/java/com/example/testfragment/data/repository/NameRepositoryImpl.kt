package com.example.testfragment.data.repository

import com.example.testfragment.data.storage.NameTrainingStorage
import com.example.testfragment.data.storage.models.ModelsNameTraining
import com.example.testfragment.domain.models.NameTraining
import com.example.testfragment.domain.models.SaveParamNameTraining
import com.example.testfragment.domain.repository.NameRepository

class NameRepositoryImpl(private val nameTrainingStorage: NameTrainingStorage) : NameRepository {

    override fun saveName(saveParam: SaveParamNameTraining): Boolean {
        val name = mapToStorage(saveParam)
        return nameTrainingStorage.save(name)
    }

    override fun getName(): NameTraining {
        val name = nameTrainingStorage.get()
        return mapToDomain(name)
    }

    private fun mapToStorage(saveParam: SaveParamNameTraining): ModelsNameTraining {
        return ModelsNameTraining(firstName = saveParam.name)
    }

    private fun mapToDomain(modelsNameTraining: ModelsNameTraining): NameTraining {
        return NameTraining(firstName = modelsNameTraining.firstName)
    }
}