package com.example.xcriticaltrainingapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticaltrainingapp.databinding.ActivityBottomNavBinding
import com.example.xcriticaltrainingapp.ui.dashboard.DashboardViewModel
import com.example.xcriticaltrainingapp.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.text.FieldPosition

@AndroidEntryPoint
class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding
    private lateinit var rc: RecyclerView
    var isLinearLayout = false
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rc = findViewById(R.id.rcViewProjects)
        val navView: BottomNavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_activity_bottom_nav)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.navigation_home -> {
                    binding.toolbar.visibility = View.VISIBLE
                }
                R.id.navigation_dashboard -> {
                    binding.toolbar.visibility = View.INVISIBLE
                }
            }
        }

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.navigation_dashboard)
        }

        navView.setupWithNavController(navController)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(binding.toolbar)

        setCloseDrawerListener()

        val fragment: Fragment = HomeFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.recycler_container, fragment, "home fragment")
        transaction.commit()
        
        binding.navToolbarView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.about_app -> {
                    navController.navigate(R.id.aboutAppInfoFragment)
                }
                R.id.notification -> {
                    navController.navigate(R.id.notificationFragment)
                }
                R.id.setting -> {
                    navController.navigate(R.id.settingsFragment2)
                }
                R.id.exit -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            binding.drawerProfile.closeDrawer(GravityCompat.START)
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

    private fun setCloseDrawerListener() {
        val headerView = binding.navToolbarView.getHeaderView(0)
        headerView?.findViewById<ImageView>(R.id.ivCloseProfile)?.setOnClickListener {
            binding.drawerProfile.closeDrawer(GravityCompat.START)
        }
    }
}