package com.example.mymenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mymenus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // активируем стрелку назад
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Admin"
        // активируем меню внизу экрана
        binding.bNavMenu.selectedItemId = R.id.bm_image
        binding.bNavMenu.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.bm_image -> {
                    Toast.makeText(this, "Image", Toast.LENGTH_SHORT).show()
                }
                R.id.bm_location_disabled -> {
                    Toast.makeText(this, "Location Disabled", Toast.LENGTH_SHORT).show()
                }
                R.id.bm_location -> {
                    Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show()
                }
                R.id.bm_my_location -> {
                    Toast.makeText(this, "My Location", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }

    // Вывод элементов меню в ToolBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }
    // Отслеживание нажатий на элементы ToolBar (ActionBar)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                Toast.makeText(this, "привет", Toast.LENGTH_SHORT).show()
            }
            R.id.save ->
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            R.id.delete ->
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
            R.id.sync ->
                Toast.makeText(this, "Sync", Toast.LENGTH_SHORT).show()
            R.id.sync_dis ->
                Toast.makeText(this, "DeSync", Toast.LENGTH_SHORT).show()

        }
        return true
    }



}