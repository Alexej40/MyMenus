package com.example.mymenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymenus.databinding.ActivityFilesBinding

class FilesActivity : AppCompatActivity() {

    lateinit var binding: ActivityFilesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilesBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}