package com.example.testfragment.data.storage

import com.example.testfragment.data.storage.models.ModelsNameTraining


interface NameTrainingStorage {

    fun save(modelsNameTraining: ModelsNameTraining): Boolean

    fun get(): ModelsNameTraining
}