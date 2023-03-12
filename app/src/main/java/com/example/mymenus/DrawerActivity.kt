package com.example.mymenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import com.example.mymenus.databinding.ActivityDrawerLayoutBinding

class DrawerActivity : AppCompatActivity() {
    lateinit var binding: ActivityDrawerLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MyLog", "DrawerActivity")
        binding.apply {
            // запускаем слушатель нажатий и стартуем меню
            bOpen.setOnClickListener {
                dLayout.openDrawer(GravityCompat.START)
            }
        }
    }
}