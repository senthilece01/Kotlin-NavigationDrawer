package com.example.senthil.kotlin_navigationdrawer

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.senthil.kotlin_navigationdrawer.Fragment.PhotosFragment
import com.example.senthil.kotlin_navigationdrawer.Fragment.MoviesFragment
import com.example.senthil.kotlin_navigationdrawer.Fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun displayScreen(id: Int){

       // val fragment =  when (id){

        when (id){
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout, HomeFragment()).commit()
            }

            R.id.nav_photos -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout, PhotosFragment()).commit()
            }

            R.id.nav_movies -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout, MoviesFragment()).commit()
            }

           R.id.nav_notifications -> {
               Toast.makeText(this, "Clicked Notifications", Toast.LENGTH_SHORT).show()
           }

           R.id.nav_settings -> {
               Toast.makeText(this, "Clicked Settings", Toast.LENGTH_SHORT).show()
           }

           R.id.nav_aboutUs -> {
               Toast.makeText(this, "Clicked About Us", Toast.LENGTH_SHORT).show()
           }

           R.id.nav_privacyPolicy -> {
               Toast.makeText(this, "Clicked Privacy Policy", Toast.LENGTH_SHORT).show()
           }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        displayScreen(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
