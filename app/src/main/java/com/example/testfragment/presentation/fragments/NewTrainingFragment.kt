package com.example.testfragment.presentation.fragments

import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.activityViewModels
import com.example.testfragment.R
import com.example.testfragment.presentation.DataModel
import com.example.testfragment.contract.navigator
import com.example.testfragment.data.repository.NameRepositoryImpl
import com.example.testfragment.data.storage.SharedPrefNameStorage
import com.example.testfragment.databinding.FragmentNewTrainingBinding
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class NewTrainingFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var  binding: FragmentNewTrainingBinding

    private val nameRepository by lazy(LazyThreadSafetyMode.NONE) {
        NameRepositoryImpl(nameTrainingStorage = SharedPrefNameStorage(context = requireContext()))
    }
    private val getNameTrainingUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.testfragment.domain.usecase.GetNameTrainingUseCase(
            nameRepository = nameRepository
        )
    }
    private val saveNameTrainingUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.testfragment.domain.usecase.SaveNameTrainingUseCase(
            nameRepository = nameRepository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTrainingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.save.setOnClickListener {
            val keyword = binding.editName.text.toString()
            val encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.name())
            dataModel.nameActivityTraining.value = encodedKeyword
            onGetTextTraining()
        }
        binding.editName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                return@setOnEditorActionListener onGetTextTraining()
            }
            return@setOnEditorActionListener false
        }

        binding.cancel.setOnClickListener {
            val text = binding.editName.text.toString()
            val params = com.example.testfragment.domain.models.SaveParamNameTraining(name = text)
            val result: Boolean = saveNameTrainingUseCase.execute(param = params)
            binding.TextView.text = "Save result = $result"
        }

        binding.save.setOnClickListener {
            val userName: com.example.testfragment.domain.models.NameTraining = getNameTrainingUseCase.execute()
            binding.TextView.text = "${userName.firstName}"
        }

    }
    private fun onGetTextTraining(): Boolean{
        val keyword = binding.editName.text.toString()
        if (keyword.isBlank()) {
            binding.editName.error = "Нет названия"
        }
        return true

    }

    private fun showAlertDialog() {
        val listener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> showToast(R.string.action_yes)
                DialogInterface.BUTTON_NEGATIVE -> showToast(R.string.action_no)
                DialogInterface.BUTTON_NEUTRAL -> {
                    showToast(R.string.action_ignore)
                }
            }
        }
        val dialog = AlertDialog.Builder(context)
            .setCancelable(true)
            //.setIcon(R.mipmap.ic_launcher_round)
            .setTitle(R.string.defolt)
            .setMessage(R.string.defolt)
            .setPositiveButton(R.string.action_yes, listener)
            .setNegativeButton(R.string.action_no, listener)
            .setNeutralButton(R.string.action_ignore, listener)

            .setOnDismissListener {
                Log.d(ContentValues.TAG, "Dialog dismissed")
            }
            .create()

        dialog.show()
    }

    private fun showToast(@StringRes messageRes: Int) {
        Toast.makeText(context, messageRes, Toast.LENGTH_SHORT).show()
    }

    private fun onBackTrainingFragment(){
        navigator().startTrainingFragment()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewTrainingFragment()
    }
}