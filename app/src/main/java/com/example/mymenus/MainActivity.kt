package com.example.mymenus

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mymenus.Constants.Constants
import com.example.mymenus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var launcher_Nav: ActivityResultLauncher<Intent>? = null
    private var launcher_Lab3: ActivityResultLauncher<Intent>? = null
    private var launcher_Lab4: ActivityResultLauncher<Intent>? = null


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
                    // открываем второе активити и работаем с ним - NavigationView
                    Toast.makeText(this, "NavigationView", Toast.LENGTH_SHORT).show()
                    launcher_Nav?.launch(Intent(this@MainActivity, NavigationActivity::class.java))

                }
                R.id.bm_location_disabled -> {
                    // открываем следующее активити для 3-й лабы
                    Toast.makeText(this, "Location Disabled", Toast.LENGTH_SHORT).show()
                    launcher_Lab3?.launch(Intent(this@MainActivity, MultiActivity::class.java))
                }
                R.id.bm_location -> {
                    // открываем второе активити и работаем с ним - DrawerLayout
                    Toast.makeText(this, "Location - New Activity", Toast.LENGTH_SHORT).show()
                    launcher?.launch(Intent(this, DrawerActivity::class.java))
                }
                R.id.bm_my_location -> {
                    // открываем активити для 4-й лабы и работаем с ним
                    Toast.makeText(this, "My Location - Лаба 4", Toast.LENGTH_SHORT).show()
                    launcher_Lab4?.launch(Intent(this, FilesActivity::class.java))
                }
            }
            true
        }
        // Запуск слушателя открытия другого активити (Drawer Activity) и возврат результата
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val resultData = result.data?.getStringExtra(Constants.DRAWER_ACTIVITY_MAIN)
                Log.d("MyLog", "Result From RecycleView ${resultData.toString()}")
            }
        }

        // Запуск слушателя открытия другого активити (Navigation Activity) и возврат результата
        launcher_Nav = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val resultData = result.data?.getStringExtra(Constants.NAVIGATION_ACTIVITY_MAIN)
                Log.d("MyLog", "Result from NavigationView ${resultData.toString()}")
            }
        }

        // Запуск слушателя открытия другого активити (MultiActivity) и возврат результата
        launcher_Lab3 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val resultData = result.data?.getStringExtra(Constants.MULTI_ACTIVITY_MAIN)
                Log.d("MyLog", "Result from MultiActivity ${resultData.toString()}")
            }
        }

        // Запуск слушателя открытия другого активити (Files Activity) и возврат результата
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val resultData = result.data?.getStringExtra(Constants.DRAWER_ACTIVITY_MAIN)
                Log.d("MyLog", "Result From RecycleView ${resultData.toString()}")
            }
        }
        // обработчик нажатий кнопкок
        binding.mainB1.setOnClickListener(listenerOnClick)
        binding.mainB1.setOnLongClickListener(listenerOnLongClick)
        binding.mainB2.setOnClickListener(listenerOnClick)
        binding.tView.setOnClickListener(listenerOnClick)




    }
    // слушатель нажатий
    val listenerOnClick= View.OnClickListener { view ->
        when (view.getId()) {
            R.id.mainB1 -> {
                Toast.makeText(this, "Big Red Button 1", Toast.LENGTH_SHORT).show()
            }
            R.id.mainB2 -> {
                Toast.makeText(this, "Big Red Button 2", Toast.LENGTH_SHORT).show()
            }
            R.id.tView -> {
                Toast.makeText(this, "Text View", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // слушатель долгих нажатий
    val listenerOnLongClick= View.OnLongClickListener {
        when (it.getId()) {
            R.id.mainB1 -> {
                Toast.makeText(this, "1st RED BUTTON long click", Toast.LENGTH_SHORT).show()
            }
        }
        true
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



