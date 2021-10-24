package com.example.knowyournetwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.knowyournetwork.Adapters.Topic_Adapter
import com.example.knowyournetwork.Database.Data
import com.example.knowyournetwork.databinding.ActivityTopicsBinding

class Topics : AppCompatActivity(), Topic_Adapter.OnItemClickListener {
    private lateinit var binding: ActivityTopicsBinding
    val Topic_list=Data().getData()
    private val adapter = Topic_Adapter(Topic_list,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title="Topics"
        binding.topicsRv.adapter=adapter
        binding.topicsRv.layoutManager= LinearLayoutManager(this)


    }



    override fun onItemClick(position: Int) {
        val intent: Intent = Intent(this,SubTopics::class.java)
        intent.putExtra("CLICKED_TOPIC",position)
        startActivity(intent)
    }
}