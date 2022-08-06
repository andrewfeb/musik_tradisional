package com.andrew.musiktradisional

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.Resource
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "Music Name"
        const val EXTRA_SOURCE = "Music Source"
        const val EXTRA_PHOTO = "Music Image"
        const val EXTRA_DETAIL = "Music Detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val musicName = intent.getStringExtra(EXTRA_NAME)
        val musicSource = intent.getStringExtra(EXTRA_SOURCE)
        val musicImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val musicDetail = intent.getStringExtra(EXTRA_DETAIL)

        title = "Detail " + musicName

        tvName.text = musicName
        tvSource.text = musicSource
        tvDetail.text = musicDetail
        imgMusic.setImageResource(musicImg)
    }
}