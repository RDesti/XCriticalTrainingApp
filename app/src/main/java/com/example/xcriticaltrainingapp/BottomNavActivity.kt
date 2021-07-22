package com.example.xcriticaltrainingapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.xcriticaltrainingapp.databinding.ActivityBottomNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding
    private lateinit var toolbar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_nav)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.navigation_dashboard)
        }

        navView.setupWithNavController(navController)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu -> {

            }
            R.id.grid_four -> {

            }
        }
        return true
    }
}