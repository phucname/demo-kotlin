package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.myapplication.dongbo_batdongbo.MainActivity
import com.google.android.material.navigation.NavigationView

class Main : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var native: NavigationView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawer=findViewById(R.id.drawer_layout)
        toolbar=findViewById(R.id.toolbar)
        native=findViewById(R.id.navigation)
        setSupportActionBar(toolbar)
        var toge= ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close)
        drawer.addDrawerListener(toge)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toge.syncState()
        getFramet(MainActivity())
        native.setNavigationItemSelectedListener(object :NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.da_luong->getFramet(MainActivity())

                }
                return true
            }

        })

    }
    fun getFramet(fram: Fragment){
        var frammaneger=supportFragmentManager
        var framaction=frammaneger.beginTransaction()
        framaction.replace(R.id.fragment_container_view_tag,fram)
        framaction.commit()
        drawer.closeDrawers()

    }
}