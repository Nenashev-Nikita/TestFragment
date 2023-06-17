package com.example.testfragment.data.storage

import android.content.Context
import com.example.testfragment.data.storage.models.ModelsNameTraining

private  const val SHARED_PREFS_NAME = "shared_prefs_name"
private  const val KEY_NAME = "firstName"
private const val DEFAULT_NAME = "Default last name"

class SharedPrefNameStorage(context: Context) : NameTrainingStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(modelsNameTraining: ModelsNameTraining): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, modelsNameTraining.firstName).apply()
        return true
    }

    override fun get(): ModelsNameTraining {
        val firstName = sharedPreferences.getString(KEY_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return ModelsNameTraining(firstName = firstName)
    }
}