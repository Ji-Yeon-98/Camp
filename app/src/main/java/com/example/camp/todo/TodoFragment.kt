package com.example.camp.todo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.camp.databinding.TodoFragmentBinding

class TodoFragment : Fragment() {

    companion object {
        const val TAG = "TodoFragment"

        fun newInstance() = TodoFragment()
    }

    private var _binding: TodoFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        TodoListAdapter()
    }

    val testList = arrayListOf<TodoModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TodoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    fun addList(title:String, content:String){
        listAdapter.addItems(TodoModel(title, content))
    }

    private fun initView() = with(binding) {
        todoList.adapter = listAdapter
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}