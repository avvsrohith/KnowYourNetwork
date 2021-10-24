package com.example.knowyournetwork.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.knowyournetwork.Database.Topic_DC
import com.example.knowyournetwork.databinding.ItemTopicBinding

class Topic_Adapter(var Topic_list:ArrayList<Topic_DC>,val listener: OnItemClickListener) : RecyclerView.Adapter<Topic_Adapter.ViewHolder>() {




    inner class ViewHolder(val binding : ItemTopicBinding) : RecyclerView.ViewHolder(binding.root),View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onItemClick(adapterPosition)
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTopicBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Current_Topic:Topic_DC = Topic_list.get(position)

        holder.binding.TopicTitle.text=Current_Topic.Title
        holder.binding.thumbnailTopic.setImageResource(Current_Topic.Thumbnail)

    }

    override fun getItemCount(): Int {
        return Topic_list.size
    }

}