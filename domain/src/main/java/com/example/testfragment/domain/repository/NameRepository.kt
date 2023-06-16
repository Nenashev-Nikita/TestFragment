package com.example.testfragment.domain.repository

import com.example.testfragment.domain.models.NameTraining
import com.example.testfragment.domain.models.SaveParamNameTraining

interface NameRepository {
    fun saveName(saveParam: SaveParamNameTraining) : Boolean

    fun getName(): NameTraining
}