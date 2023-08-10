package com.example.camp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val num_page = 2

    //viewpager에 보여줄 fragment 수 가져오기
    override fun getItemCount(): Int {
        return num_page
    }

    //위치에 따른 fragment 생성하기
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {FragmentTodo()}
            else -> {FragmentBookmark.newInstance("Bookmark")}
        }
    }
}