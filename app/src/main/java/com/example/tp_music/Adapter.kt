package com.example.tp_music

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(var context: Context,var list: ArrayList<MusicModel>): BaseAdapter(){

    override fun getCount(): Int {
        return list.size

    }

    override fun getItem(position: Int): MusicModel {
       return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.activity_main2 ,parent,false)

        val imageView = rowView.findViewById<ImageView>(R.id.imageView)
        val textView1 = rowView.findViewById<TextView>(R.id.text)


        val music = getItem(position)

        imageView.setImageResource(music.image)
        textView1.text =(music.title)


        return rowView
    }

}