package com.vitorota.placeholder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */
class MainActivity : AppCompatActivity() {

    private val navController get() = findNavController(R.id.navHostFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}