package com.neoutils.highlight.example.view.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neoutils.highlight.example.view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnEditText.setOnClickListener {
            startActivity(Intent(this, EditTextActivity::class.java))
        }

        binding.btnTextView.setOnClickListener {
            startActivity(Intent(this, TextViewActivity::class.java))
        }
    }
}