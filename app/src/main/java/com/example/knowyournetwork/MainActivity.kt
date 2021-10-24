package com.example.knowyournetwork

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowyournetwork.Database.Subtopic_DC
import com.example.knowyournetwork.Database.Topic_DC
import com.example.knowyournetwork.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    public  val Topic_list :ArrayList<Topic_DC> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.topicBtn.setOnClickListener {
            val intent: Intent = Intent(this, Topics::class.java)
            startActivity(intent)
        }

        binding.calcBtn.setOnClickListener {
        val intent: Intent = Intent(this, Formulae::class.java)
        startActivity(intent)
    }




    }


}