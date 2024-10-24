package com.neoutils.highlight.example.view.launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neoutils.highlight.example.view.databinding.ActivityTextViewBinding

class TextViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}