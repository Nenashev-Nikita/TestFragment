package com.example.testfragment.features.exercises.di

import com.example.testfragment.features.exercises.data.api.ExercisesApi
import com.example.testfragment.features.exercises.data.datasource.ExercisesDataSource
import com.example.testfragment.features.exercises.data.datasource.ExercisesDataSourceImpl
import com.example.testfragment.features.exercises.data.repository.ExercisesRepositoryImpl
import com.example.testfragment.features.exercises.domain.repository.ExercisesRepository
import com.example.testfragment.features.exercises.domain.usecase.GetExercisesUseCase
import com.example.testfragment.features.exercises.presentation.ExercisesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val exercisesModule = module {
    single { get<Retrofit>().create(ExercisesApi::class.java) }

    factory<ExercisesDataSource> { ExercisesDataSourceImpl(exercisesApi = get()) }
    factory<ExercisesRepository> { ExercisesRepositoryImpl(exercisesDataSource = get()) }
    factory { GetExercisesUseCase(exercisesRepository = get()) }

    viewModel {
        ExercisesViewModel(
            getExercisesUseCase = get(),
        )
    }
}