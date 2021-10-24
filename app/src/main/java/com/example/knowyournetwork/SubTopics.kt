package com.example .knowyournetwork

import android.R
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.knowyournetwork.Adapters.Subtopic_Adapter
import com.example.knowyournetwork.Database.Data
import com.example.knowyournetwork.Database.Subtopic_DC
import com.example.knowyournetwork.Database.Topic_DC
import com.example.knowyournetwork.databinding.ActivitySubTopicsBinding

class SubTopics : AppCompatActivity(),Subtopic_Adapter.OnItemClickListener {
    private lateinit var binding: ActivitySubTopicsBinding
    val SubTopic_list : ArrayList<Subtopic_DC> = ArrayList()
    var position_topic : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySubTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        position_topic=intent.getIntExtra("CLICKED_TOPIC",0)
        setTitle(Data().getData().get(position_topic).Title)

        binding.rvSubtopics.adapter= Subtopic_Adapter(getSubtopics(position_topic),this)
        binding.rvSubtopics.layoutManager=LinearLayoutManager(this)


    }

    fun getSubtopics(position:Int) : ArrayList<Subtopic_DC>{
        val topic : Topic_DC = Data().getData().get(position)

        return topic.subtopic
    }

    override fun OnItemCLick(position: Int) {
        val intent: Intent = Intent(this,Info::class.java)
        intent.putExtra("CLICKED_TOPIC",position_topic)
        intent.putExtra("CLICKED_SUBTOPIC",position)
        startActivity(intent)
    }
}