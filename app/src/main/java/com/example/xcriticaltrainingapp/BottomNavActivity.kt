package com.example.xcriticaltrainingapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.xcriticaltrainingapp.databinding.ActivityBottomNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_nav)

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.navigation_dashboard)
        }

        navView.setupWithNavController(navController)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(binding.toolbar)
        
        binding.navToolbarView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.about_app -> {
                    Toast.makeText(this@BottomNavActivity, "about_app", Toast.LENGTH_SHORT).show()
                }
                R.id.notification -> {

                }
                R.id.setting -> {

                }
                R.id.exit -> {

                }
                R.id.ivCloseProfile -> {
                    binding.drawerProfile.closeDrawer(GravityCompat.START)

                }
            }


            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                binding.drawerProfile.openDrawer(GravityCompat.START)
            }
            R.id.grid_four -> {

            }
        }
        return true
    }
}