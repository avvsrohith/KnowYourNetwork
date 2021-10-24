package com.example.knowyournetwork.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.knowyournetwork.Database.Subtopic_DC
import com.example.knowyournetwork.R
import com.example.knowyournetwork.databinding.ItemSubtopicBinding

class Subtopic_Adapter(var SubTopic_List:ArrayList<Subtopic_DC>,val listener : OnItemClickListener) : RecyclerView.Adapter<Subtopic_Adapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemSubtopicBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.OnItemCLick(adapterPosition)
        }

    }

    interface OnItemClickListener{
        fun OnItemCLick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSubtopicBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var current_subtopic:Subtopic_DC=SubTopic_List.get(position)

        holder.binding.SubTopicTitle.text=current_subtopic.Title

    }

    override fun getItemCount(): Int {
        return SubTopic_List.size
    }
}