package com.rhuamani.navigation_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottonNavigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottonNavigation = findViewById(R.id.menuNavigation)

        reemplazarFragmento(Inicio())
        bottonNavigation.setOnItemReselectedListener {
            when(it.itemId){
                R.id.navInicio -> reemplazarFragmento(Inicio())
                R.id.navOp2 -> reemplazarFragmento(Opcion2Fragment())
                R.id.navOp3 -> reemplazarFragmento(Opcion3Fragment())
                else -> {}
            }
            true
        }
    }

    private fun reemplazarFragmento(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }
}