package com.example.camp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.camp.databinding.FragmentTodoBinding

class FragmentTodo : Fragment() {

    private lateinit var binding: FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    // 프래그먼트 뷰가 생성되고 나서 호출 : RecyclerView에 표시할 준비
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val items = addData()
        val adapter = RVAdapter(items)

        //recycelrView 어댑터 연결
        binding.recyclerView.adapter = adapter

        //LinearLayoutManager : 세로로 리스트 나열
        binding.recyclerView.layoutManager  = LinearLayoutManager(requireContext())
    }

    // RecyclerView에 들어갈 list 생성
    fun addData():ArrayList<String>{
        val list = ArrayList<String>()
        for ( i in 0 until 20){
            list.add("todo")
        }
        return list
    }

}