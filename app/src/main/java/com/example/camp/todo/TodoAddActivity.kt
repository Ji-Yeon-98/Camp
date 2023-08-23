package com.example.camp.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.camp.databinding.TodoAddActivityBinding
import com.example.camp.main.MainActivity

class TodoAddActivity : AppCompatActivity() {

    private lateinit var binding: TodoAddActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "할 일"

        binding.toolbar2.setNavigationOnClickListener{
            finish()
        }


        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()

            intent.putExtra("title", title)
            intent.putExtra("content", content)
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}