package com.example.mymenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.mymenus.databinding.ActivityNavigationBinding


class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MyLog", "Navigation View")
        binding.apply {
            // запускаем слушатель нажатий и стартуем меню
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.navItem11 -> {
                        Toast.makeText(this@NavigationActivity, "navItem11", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navItem12 -> {
                        Toast.makeText(this@NavigationActivity, "navItem12", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navItem13 -> {
                        Toast.makeText(this@NavigationActivity, "navItem13", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navItem21 -> {
                        Toast.makeText(this@NavigationActivity, "navItem21", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navItem22 -> {
                        Toast.makeText(this@NavigationActivity, "navItem22", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navItem23 -> {
                        Toast.makeText(this@NavigationActivity, "navItem23", Toast.LENGTH_SHORT).show()
                    }
                }
                navLayout.closeDrawer(GravityCompat.START)
                true
            }


            navView.setOnClickListener {
                navLayout.openDrawer(GravityCompat.START)
            }
        }

    }
}