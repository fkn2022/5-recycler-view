package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var catsAdapter: CatsAdapter

    private val lotsOfCats = listOf(
        "Kitty", "Catsy", "Пушистый П", "Старый моряк", "Матроскин", "Степаныч", "Lion King",
        "Crabb", "C3PIO", "Твоя Б", "Одноглазый Джо", "Двуглазый Джо", "ШарикоподшипниковскийКотяра"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        catsAdapter = CatsAdapter()
        binding.itemsList.apply {
            adapter = catsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.addItem.setOnClickListener {
            catsAdapter.cats = catsAdapter.cats + CatsAdapter.Cat(lotsOfCats.random(), Random.nextInt(0, 30))
        }
    }
}