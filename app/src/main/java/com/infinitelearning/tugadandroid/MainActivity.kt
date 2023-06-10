package com.infinitelearning.tugadandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.infinitelearning.tugadandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var btnSementara: Button? = null
    var btnSementara1: Button? = null
    private lateinit var binding: ActivityMainBinding




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(BerandaFragment())

        //color actionbar

        //buttom
        btnSementara = findViewById(R.id.button)
        btnSementara1 = findViewById(R.id.button1)

        btnSementara?.setOnClickListener {
            startActivity(Intent(this@MainActivity, PelaporActivity::class.java))
        }

        btnSementara1?.setOnClickListener {
            startActivity(Intent(this@MainActivity, NavigationDrawerActivity::class.java))
        }

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.beranda -> replaceFragment(BerandaFragment())
                R.id.laporan -> replaceFragment(LaporanFragment())
                R.id.edukasi -> replaceFragment(EdukasiFragment())
                R.id.kontak -> replaceFragment(KontakFragment())

                else -> {

                }

            }

            true
        }




    }



    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    //toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    //menampilkan popup ketika menekan toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tb_seach -> Toast.makeText(this, "Anda Menekan Search", Toast.LENGTH_LONG).show()
            R.id.tb_favorite -> Toast.makeText(this, "Anda Menekan Favorite", Toast.LENGTH_LONG).show()
            R.id.tb_notif -> Toast.makeText(this, "Anda Menekan Notification", Toast.LENGTH_LONG).show()
            R.id.tb_contact -> Toast.makeText(this, "Anda Menekan Contact", Toast.LENGTH_LONG).show()
            R.id.tb_setting -> Toast.makeText(this, "Anda Menekan Setting", Toast.LENGTH_LONG).show()
            R.id.tb_close -> finish()
        }
        return true


    }
}