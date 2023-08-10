package com.example.camp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.camp.databinding.FragmentBookmarkBinding
import com.example.camp.databinding.FragmentTodoBinding

// 프래그먼트 초기화 파라미터
private const val ARG_PARAM1 = "param1"

class FragmentBookmark : Fragment() {

    //변수 설정
    private var param1: String? = null

    //뷰 바인딩 객체 저장
    private var _binding: FragmentBookmarkBinding?= null
    private val bbinding get() = _binding!!

    // 프래그먼트 생성될 때 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //arguments : Bundle 객체, 프래그먼트 간 데이터 전달
        arguments?.let {
            //초기화 파라미터 가져와서 변수에 저장
            param1 = it.getString(ARG_PARAM1)
        }
    }

    // 프래그먼트 뷰 생성하고 초기화
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return bbinding.root
    }

    // 프래그먼트 소멸될 때 호출
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    // 뷰가 생성되고 난 뒤 호출
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val items = addData()
        val adapter = RVAdapter(items)
        bbinding.recyclerView2.adapter = adapter
        bbinding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
    }


    fun addData():ArrayList<String>{
        val list = ArrayList<String>()
        for ( i in 0 until 20){
            list.add("bookmark")
        }
        return list
    }

    companion object {
        // 팩토리 메서드 : 파라미터를 사용해 새로운 프래그먼트 인스턴스 생성하는 데 사용
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentBookmark().apply {
                arguments = Bundle().apply {
                    //ARG_PARAM1이라는 키에 param1 값 할당
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}