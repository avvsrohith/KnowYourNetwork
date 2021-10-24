package com.example.knowyournetwork.Database

import com.example.knowyournetwork.R

class Data {


    fun getData() :ArrayList<Topic_DC> {

        val topiclist:ArrayList<Topic_DC> = ArrayList<Topic_DC>()
        val subtopic_list_1: ArrayList<Subtopic_DC> = ArrayList<Subtopic_DC>()
        val formula_list_1 : ArrayList<String> = ArrayList<String>()



        subtopic_list_1.add(Subtopic_DC("Resonance", "attenuators.pdf"))
        subtopic_list_1.add((Subtopic_DC("Bandwidth", "attenuators.pdf")))
        subtopic_list_1.add(Subtopic_DC("Miscellaneous","attenuators.pdf"))
        subtopic_list_1.add(Subtopic_DC("Cheat Sheet","attenuators.pdf"))

        topiclist.add(Topic_DC(R.drawable.attenuator,"RLC Analysis",subtopic_list_1))

        val subtopic_list_2: ArrayList<Subtopic_DC> = ArrayList<Subtopic_DC>()

        subtopic_list_2.add(Subtopic_DC("T type", "attenuators.pdf"),)
        subtopic_list_2.add((Subtopic_DC("Pi type", "attenuators.pdf")))
        subtopic_list_2.add(Subtopic_DC("Miscellaneous","attenuators.pdf"))
        subtopic_list_2.add(Subtopic_DC("Cheat Sheet","attenuators.pdf"))

        topiclist.add(Topic_DC(R.drawable.attenuator,"Attenuators",subtopic_list_2))

        return topiclist
    }


}