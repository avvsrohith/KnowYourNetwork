package com.example.knowyournetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowyournetwork.Database.Data
import com.example.knowyournetwork.databinding.ActivityInfoBinding


class Info : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position_subtopic = intent.getIntExtra("CLICKED_SUBTOPIC",0)
        val position_topic = intent.getIntExtra("CLICKED_TOPIC",0)

        binding.pdfViewer.fromAsset(Data().getData().get(position_topic).subtopic.get(position_subtopic).pdf_Title).load()

    }
}