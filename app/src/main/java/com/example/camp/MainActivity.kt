package com.example.camp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.camp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // tab 이름 리스트
    var tabText = listOf<String>("Todo", "Bookmark")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewPager의 adapter 프로퍼티에 새로운 ViewPagerAdapter 객체 할당
        binding.viewPager.apply {
            adapter = ViewPagerAdapter(context as FragmentActivity)
        }

        //Tablayout과 viewpager 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            //각 탭과 해당 위치를 받아와서 작업 수행
            tab, position -> tab.text = tabText[position]
        }.attach()

    }
}