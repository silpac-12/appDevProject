package com.example.appdevelopmentproject.fragments.loginRegister

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.appdevelopmentproject.data.User
import com.example.appdevelopmentproject.databinding.FragmentRegisterBinding
import com.example.appdevelopmentproject.util.Resource
import com.example.appdevelopmentproject.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.zip.Inflater

@AndroidEntryPoint

class RegisterFragment: Fragment() {
    private val TAG = "RegisterFragment"
    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonRegister.setOnClickListener {
                val user = User(
                    editTextFirstName.text.toString().trim(),
                    editTextSecondName.text.toString().trim(),
                    editTextEmail.text.toString().trim()
                )
                val password = editTextConfirmPassword.text.toString()
                viewModel.createAccount(user, password)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.register.collect{
                when(it){
                    is Resource.Loading -> {
                        binding.buttonRegister.startAnimation()
                    }
                    is Resource.Success -> {
                        Log.d("test", it.message.toString())
                        binding.buttonRegister.revertAnimation()
                    }
                    is Resource.Error -> {
                        Log.e(TAG, it.message.toString())
                        binding.buttonRegister.revertAnimation()
                    }
                    else -> Unit
                }
            }
        }
    }
}