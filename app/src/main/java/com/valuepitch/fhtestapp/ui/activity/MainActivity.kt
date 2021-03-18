package com.valuepitch.fhtestapp.ui.activity

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.valuepitch.fhtestapp.R
import com.valuepitch.fhtestapp.ui.BottomNavigationCircles
import com.valuepitch.fhtestapp.ui.fragment.DashboardFragment
import com.valuepitch.fhtestapp.ui.fragment.ProfileFragment
import com.valuepitch.fhtestapp.ui.fragment.SettingFragment

class MainActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationCircles = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    val mFragment =
                        DashboardFragment()
                    openFragment(mFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_setting -> {
                    val mFragment =
                        SettingFragment()
                    openFragment(mFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    val mFragment =
                        ProfileFragment()
                    openFragment(mFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
        transaction.replace(R.id.nav_host_fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            this.finish()
            this.finishAffinity()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this@MainActivity, "Press again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}