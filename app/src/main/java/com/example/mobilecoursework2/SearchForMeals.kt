package com.example.mobilecoursework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchForMeals : AppCompatActivity() {

    private lateinit var mealDao: MealDao

    private lateinit var editTextSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var recyclerView: RecyclerView
    private var adapter: MealAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_for_meals)

        editTextSearch = findViewById(R.id.editTextSearch)
        btnSearch = findViewById(R.id.btnSearch)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MealAdapter()
        recyclerView.adapter = adapter

        val db = MealDatabase.getDatabase(applicationContext)
        mealDao = db.mealDao()

        btnSearch.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val mealList = mealDao.getAll()
                val meals = ArrayList<Meal>()
                for (meal in mealList) {
                    meals.add(meal)
                }
                withContext(Dispatchers.Main) {
                    // Update UI on the main thread
                    adapter?.addItems(meals)

                }
            }
        }



    }
}