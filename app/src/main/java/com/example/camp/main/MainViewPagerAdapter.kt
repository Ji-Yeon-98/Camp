package com.example.camp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.camp.R
import com.example.camp.bookmark.BookmarkFragment
import com.example.camp.todo.TodoFragment

class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = ArrayList<MainTabs>()

    init {
        fragments.add(
            MainTabs(TodoFragment.newInstance(), "Todo")
        )
        fragments.add(
            MainTabs(BookmarkFragment.newInstance(), "Bookmark"),
        )
    }

    fun getTodoFragment() : Fragment{
        return fragments[0].fragment
    }

    fun getTitle(position: Int): String {
        return fragments[position].titleRes
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }
}