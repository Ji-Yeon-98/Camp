package com.example.camp.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.viewpager2.widget.ViewPager2
import com.example.camp.R
import com.example.camp.databinding.MainActivityBinding
import com.example.camp.todo.TodoAddActivity
import com.example.camp.todo.TodoFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() = with(binding) {
        toolBar.title = getString(R.string.app_name)

        viewPager.adapter = viewPagerAdapter

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
                val titleText = result.data?.getStringExtra("title").toString()
                val content = result.data?.getStringExtra("content").toString()

                val todoFragment = viewPagerAdapter.getTodoFragment() as TodoFragment

                if (titleText != null) {
                    if (content != null) {
                        todoFragment.addList(titleText, content) // titleText와 content를 전달하여 호출
                    } else {
                        todoFragment.addList(titleText, "") // titleText만 전달하여 호출
                    }
                }
            }
        }



        // FloatingActionButton 숨기기
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // 페이지가 선택되었을 때 호출됩니다.
                super.onPageSelected(position)
                if(position == 0){
                    binding.fabAddTodo.show()
                }else{
                    binding.fabAddTodo.hide()
                }
            }
        })

        // TabLayout x ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        // fab
        fabAddTodo.setOnClickListener {
            val intent = Intent(it.context, TodoAddActivity::class.java)
            resultLauncher.launch(intent)
        }

    }
}