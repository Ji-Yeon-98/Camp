package com.example.camp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.camp.databinding.ItemRvBinding
import org.w3c.dom.Text

//RVAdapter 생성자 : 문자열 데이터
class RVAdapter(private val items:ArrayList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {


    // 생성자에서 ItemRvBinding을 받아와 itemRecyclerView.xml의 요소에 접근할 수 있게 설정
    class ViewHolder(private val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root){
        var textView: TextView = binding.tvItem
    }

    // data의 개수 반환 (문자열 데이터의 크기)
    override fun getItemCount(): Int {
        return items.size
    }

    // View 객체를 담고 있는 ViewHolder 생성 : XML 레이아웃을 인플레이트하고 새로운 뷰 홀더 객체 생성
    // 리스트 목록이 10개라면 13~15정도 여유있게 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // LayoutInflater : XML 레이아웃 파일을 실제 뷰 객체로 변환
        // parent.context : 부모 뷰 그룹의 컨텍스트
        val view = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    // ViewHolder에 data를 바인딩
    // 데이터가 스크롤 되어서 맨 위에 있던 객체가 맨 아래로 이동하면 레이아웃은 재사용, 데이터는 새롭게 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

}