package com.infinitelearning.tugadandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class NavigationDrawerActivity : AppCompatActivity() {

    //navmenu
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        //navmenu
        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_beranda -> Toast.makeText(applicationContext,"Anda menekan beranda", Toast.LENGTH_SHORT).show()
                R.id.nav_fav -> Toast.makeText(applicationContext,"Anda menekan favorite", Toast.LENGTH_SHORT).show()
                R.id.nav_kontak -> Toast.makeText(applicationContext,"Anda menekan kontak", Toast.LENGTH_SHORT).show()
                R.id.nav_notif -> Toast.makeText(applicationContext,"Anda menekan notification", Toast.LENGTH_SHORT).show()
                R.id.nav_setting -> Toast.makeText(applicationContext,"Anda menekan setting", Toast.LENGTH_SHORT).show()
                R.id.nav_login -> Toast.makeText(applicationContext,"Anda menekan login", Toast.LENGTH_SHORT).show()

            }
            true
        }

    }

    //navmenu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //navmenu
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)

    }
}