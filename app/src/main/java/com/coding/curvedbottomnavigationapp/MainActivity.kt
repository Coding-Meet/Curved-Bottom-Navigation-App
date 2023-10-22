package com.coding.curvedbottomnavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.coding.curvedbottomnavigationapp.fragments.HomeFragment
import com.coding.curvedbottomnavigationapp.fragments.NotificationFragment
import com.coding.curvedbottomnavigationapp.fragments.SettingFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Notification",R.drawable.ic_notifications_24)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Home",R.drawable.ic_home_24)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"Setting",R.drawable.ic_settings_24)
        )

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(NotificationFragment())
                }
                2 -> {
                    replaceFragment(HomeFragment())
                }
                3 -> {
                    replaceFragment(SettingFragment())
                }
            }
        }

        // default Bottom Tab Selected
        replaceFragment(HomeFragment())
        bottomNavigation.show(2)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}