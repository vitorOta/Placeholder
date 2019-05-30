package com.vitorota.placeholder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */
class MainActivity : AppCompatActivity() {

    private val navController get() = findNavController(R.id.navHostFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_albums -> navController.navigate(R.id.albumsFragment)
                R.id.menu_posts -> navController.navigate(R.id.postsFragment)
                R.id.menu_todo -> navController.navigate(R.id.todoFragment)
            }
            true
        }
    }
}