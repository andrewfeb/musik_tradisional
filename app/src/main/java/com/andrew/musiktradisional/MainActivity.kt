package com.andrew.musiktradisional

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvMusic: RecyclerView
    private val list:ArrayList<Music> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title ="Daftar Musik Tradisional"
        rvMusic = findViewById(R.id.rv_list)
        rvMusic.setHasFixedSize(true)

        list.addAll(MusicData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvMusic.layoutManager = LinearLayoutManager(this)
        val listMusicAdapter = ListMusicAdapter(list)
        rvMusic.adapter = listMusicAdapter

        listMusicAdapter.setOnItemClickCallback(object:ListMusicAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Music) {
                val manageDetail = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_NAME, data.name)
                    putExtra(DetailActivity.EXTRA_SOURCE, data.source)
                    putExtra(DetailActivity.EXTRA_DETAIL, data.detail)
                    putExtra(DetailActivity.EXTRA_PHOTO, data.photo)
                }

                startActivity(manageDetail)
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.mnAbout->{
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }
}