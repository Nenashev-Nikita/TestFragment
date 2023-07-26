package com.example.testfragment.features.exercises.data.mapper

import com.example.testfragment.features.exercises.data.dto.ExerciseDTO
import com.example.testfragment.features.exercises.domain.entity.ExerciseEntity

fun ExerciseDTO.toEntity(): ExerciseEntity =
    ExerciseEntity(
        name = name,
        type = type,
        muscle = muscle,
        equipment = equipment,
        difficulty = difficulty,
        instructions = instructions,
    )

fun List<ExerciseDTO>.toEntity(): List<ExerciseEntity> =
    map(ExerciseDTO::toEntity)