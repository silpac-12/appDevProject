package com.example.appdevelopmentproject.activities

import android.os.Bundle
import com.example.appdevelopmentproject.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.example.appdevelopmentproject.ui.theme.AppDevelopmentProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginRegisterActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login_register)
        setContentView(R.layout.activity_login_register)
    }
}
