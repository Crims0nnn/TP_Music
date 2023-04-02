package com.example.tp_music

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.liste)
        val image = findViewById<ImageView>(R.id.imageView)
        val texte = findViewById<TextView>(R.id.textView)
        val tablo = generatePlayListe()
        val adapter = Adapter(this , generatePlayListe())
        val play = findViewById<FloatingActionButton>(R.id.play)
        val skip = findViewById<FloatingActionButton>(R.id.skip)
        val back = findViewById<FloatingActionButton>(R.id.previousSkip)
        var index = 0


        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            index = position
            var mediaPlayer= MediaPlayer.create(this,tablo[position].son)
            image.setImageResource(tablo[index].image)
            texte.text = tablo[index].title

        play.setOnClickListener {

            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                play.setImageResource(R.drawable.baseline_stop)
            } else {
                mediaPlayer.start()
                play.setImageResource(R.drawable.baseline_play)
            }
        }
            skip.setOnClickListener {
                index += position + 1
                if (index >= tablo.size) {
                    index = 0
                }
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this,tablo[index].son)
                image.setImageResource(tablo[index].image)
                texte.text = tablo[index].title
                mediaPlayer.start()

            }
            back.setOnClickListener {
                index += position - 1
                if (index < 0) {
                    index = tablo.size - 1
                }
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this, tablo[index].son)
                image.setImageResource(tablo[index].image)
                texte.text = tablo[index].title
                mediaPlayer.start()
            }
        }
        }

    }



fun generatePlayListe(): ArrayList<MusicModel>{
    return arrayListOf(
        MusicModel(
            R.drawable.re2,
            R.raw.re2,
            "Resident Evil 2 Remake-Tyran "
        ),
        MusicModel(
            R.drawable.alone,
            R.raw.alanwalker_alone,
            "Alan Walker & Ava Max - Alone, Pt. II "
        ),
        MusicModel(
            R.drawable.after,
            R.raw.after,
            "Nightcore - After Dark "
        ),
        MusicModel(
            R.drawable.unforgettable,
            R.raw.french_montana_unforgettable_ft_swae_lee,
            "French Montana Unforgettable ft Swae Lee "
        ),
        MusicModel(
            R.drawable.zaralarsson,
            R.raw.zara_larsson,
            "Zara Larsson Aint My Fault. "
        ),


    )
}