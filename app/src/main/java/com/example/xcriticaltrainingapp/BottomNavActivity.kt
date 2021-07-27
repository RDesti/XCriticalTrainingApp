package com.example.xcriticaltrainingapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticaltrainingapp.databinding.ActivityBottomNavBinding
import com.example.xcriticaltrainingapp.ui.dashboard.DashboardViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding
    private lateinit var rc: RecyclerView
    var isLinearLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rc = findViewById(R.id.rcViewProjects)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_nav)

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.navigation_dashboard)
        }

        navView.setupWithNavController(navController)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(binding.toolbar)

        setCloseDrawerListener()
        
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
            }

            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        var tvTitle = findViewById<EditText>(R.id.editTextTitleAddProject)
        var tvScenario = findViewById<EditText>(R.id.editTextTextScenario)

        when(item.itemId){
            android.R.id.home -> {
                binding.drawerProfile.openDrawer(GravityCompat.START)
            }
            R.id.grid_four -> {
                if(isLinearLayout) {
                    rc.layoutManager = LinearLayoutManager(this@BottomNavActivity)
                    isLinearLayout = false
                }
                else{
                    rc.layoutManager = GridLayoutManager(this@BottomNavActivity, 2,GridLayoutManager.VERTICAL, false )
                    isLinearLayout = true
                }
            }
            R.id.save -> {
                dashboardViewModel.addNewProject(tvTitle.text.toString(), tvScenario.text.toString())
                tvTitle.text.clear()
                tvScenario.text.clear()
            }
        }
        return true
    }

    private fun setCloseDrawerListener(){
        val headerView = binding.navToolbarView?.getHeaderView(0)
        val closeDrawer = headerView?.findViewById<ImageView>(R.id.ivCloseProfile)
        if (closeDrawer != null) {
            closeDrawer.setOnClickListener {
                binding.drawerProfile.closeDrawer(GravityCompat.START)
            }
        }
    }
}