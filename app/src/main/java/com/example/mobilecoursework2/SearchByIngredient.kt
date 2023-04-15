package com.example.mobilecoursework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class SearchByIngredient : AppCompatActivity() {

    private lateinit var btnRetrieveMeals: Button

    private lateinit var txtIngredient: TextView
    private lateinit var showRetrievedMeals: TextView
    //private lateinit var jsonString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_ingredient)

        btnRetrieveMeals = findViewById(R.id.btnRetrieveMeals)

        txtIngredient = findViewById(R.id.txtIngredient)
        showRetrievedMeals = findViewById(R.id.showRetrievedMeals)

        val ingredient = txtIngredient.text

        btnRetrieveMeals.setOnClickListener {
            val url = URL("https://www.themealdb.com/api/json/v1/1/search.php?s=$ingredient")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"


            CoroutineScope(Dispatchers.IO).launch {
                val inputStream = connection.inputStream
                val jsonString = inputStream.bufferedReader().use { it.readText() }
                inputStream.close()
                connection.disconnect()
                val finalText = parseJson(jsonString)
                withContext(Dispatchers.Main) {
                    showRetrievedMeals.text = finalText
                }
            }
        }
    }

    private fun convertStreamToString(inputStream: InputStream): String {
        val scanner = Scanner(inputStream).useDelimiter("\\A")
        return if (scanner.hasNext()) scanner.next() else ""
    }

    private fun parseJson(json: String): String {
        val data = JSONObject(json)
        val meals = data.getJSONArray("meals")
        val sb = StringBuilder()
        for (i in 0 until meals.length()) {
            val meal = meals.getJSONObject(i)
            sb.append("Meal:").append(meal.getString("strMeal")).append("\n")
            sb.append("DrinkAlternate:").append(meal.getString("strDrinkAlternate")).append("\n")
            sb.append("Category:").append(meal.getString("strCategory")).append("\n")
            sb.append("Area:").append(meal.getString("strArea")).append("\n")
            sb.append("Instructions:").append(meal.getString("strInstructions")).append("\n")
            sb.append("Tags:").append(meal.getString("strTags")).append("\n")
            sb.append("Youtube:").append(meal.getString("strYoutube")).append("\n")

            // loop through all the ingredient and measure fields and append to the string builder
            for (j in 1..20) { // assuming there can be max 20 ingredients and measures
                val ingredient = meal.getString("strIngredient$j")
                val measure = meal.getString("strMeasure$j")
                if (ingredient.isNotEmpty() && measure.isNotEmpty()) {
                    sb.append("Ingredient$j:").append(ingredient).append("\n")
                    sb.append("Measure$j:").append(measure).append("\n")
                }
            }
            sb.append("\n")
        }
        return sb.toString()
    }
}