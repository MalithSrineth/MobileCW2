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
import com.google.gson.Gson
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class SearchByIngredient : AppCompatActivity() {

    private lateinit var mealDao: MealDao

    private lateinit var btnRetrieveMeals: Button
    private lateinit var btnSaveMealsToDB: Button

    private lateinit var txtIngredient: TextView
    private lateinit var showRetrievedMeals: TextView
    private lateinit var jsonString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_ingredient)

        btnRetrieveMeals = findViewById(R.id.btnRetrieveMeals)
        btnSaveMealsToDB = findViewById(R.id.btnSaveMealsToDB)

        txtIngredient = findViewById(R.id.txtIngredient)
        showRetrievedMeals = findViewById(R.id.showRetrievedMeals)

        val ingredient = txtIngredient.text

        val db = MealDatabase.getDatabase(applicationContext)
        mealDao = db.mealDao()

        btnRetrieveMeals.setOnClickListener {
            val url = URL("https://www.themealdb.com/api/json/v1/1/search.php?s=$ingredient")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"


            CoroutineScope(Dispatchers.IO).launch {
                val inputStream = connection.inputStream
                jsonString = inputStream.bufferedReader().use { it.readText() }
                inputStream.close()
                connection.disconnect()
                val finalText = parseJson(jsonString)
                withContext(Dispatchers.Main) {
                    showRetrievedMeals.text = finalText
                }
            }
        }

        btnSaveMealsToDB.setOnClickListener {
//            val url2 = URL("https://www.themealdb.com/api/json/v1/1/filter.php?i=$ingredient")
//            val connection2 = url2.openConnection() as HttpURLConnection
//            val inputStream2 = connection2.inputStream
//            val jsonString2 = inputStream2.bufferedReader().use { it.readText() }

            CoroutineScope(Dispatchers.IO).launch {
                val mealList = returnMeals(jsonString)
                mealDao.insertAll(mealList)
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
            sb.append("\"Meal\":").append("\""+meal.getString("strMeal")+"\"").append("\n")
            if (meal.getString("strDrinkAlternate") != "null")
                sb.append("\"DrinkAlternate\":").append("\""+meal.getString("strDrinkAlternate")+"\"").append("\n")
            else
                sb.append("\"DrinkAlternate\":").append(meal.getString("strDrinkAlternate")).append("\n")
            sb.append("\"Category\":").append("\""+meal.getString("strCategory")+"\"").append("\n")
            sb.append("\"Area\":").append("\""+meal.getString("strArea")+"\"").append("\n")
            sb.append("\"Instructions\":").append("\""+meal.getString("strInstructions")+"\"").append("\n")
            if(meal.getString("strTags") != "null")
                sb.append("\"Tags\":").append("\""+meal.getString("strTags")+"\"").append("\n")
            else
                sb.append("\"Tags\":").append(meal.getString("strTags")).append("\n")
            sb.append("\"Youtube\":").append("\""+meal.getString("strYoutube")+"\"").append("\n")

            // loop through all the ingredient and measure fields and append to the string builder

            for (j in 1..20) { // assuming there can be max 20 ingredients and measures
                val ingredient = meal.getString("strIngredient$j")
                sb.append("\"Ingredient$j\":").append("\"$ingredient\"").append("\n")
//                if (ingredient.isNotEmpty() && measure.isNotEmpty()) {
//                    sb.append("Ingredient$j:").append(ingredient).append("\n")
//                    sb.append("Measure$j:").append(measure).append("\n")
//                }
            }

            for (k in 1..20) { // assuming there can be max 20 ingredients and measures
                val measure = meal.getString("strMeasure$k")
                sb.append("\"Measure$k\":").append("\"$measure\"").append("\n")
            }
            sb.append("\n")
        }
        return sb.toString()
    }

    private fun returnMeals(json: String): List<Meal> {
        val data = JSONObject(json)
        val meals = data.getJSONArray("meals")
        val mealList = mutableListOf<Meal>()
        for (i in 0 until meals.length()) {
            val meal = meals.getJSONObject(i)
            val name = meal.getString("strMeal")
            val drinkAlternate = if (meal.getString("strDrinkAlternate") != "null") meal.getString("strDrinkAlternate") else null
            val category = meal.getString("strCategory")
            val area = meal.getString("strArea")
            val instructions = meal.getString("strInstructions")
            val mealThumb = meal.getString("strMealThumb")
            val tags = if (meal.getString("strTags") != "null") meal.getString("strTags") else null
            val youtube = meal.getString("strYoutube")
            val ingredient1 = meal.getString("strIngredient1")
            val ingredient2 = meal.getString("strIngredient2")
            val ingredient3 = meal.getString("strIngredient3")
            val ingredient4 = meal.getString("strIngredient4")
            val ingredient5 = meal.getString("strIngredient5")
            val ingredient6 = meal.getString("strIngredient6")
            val ingredient7 = meal.getString("strIngredient7")
            val ingredient8 = meal.getString("strIngredient8")
            val ingredient9 = meal.getString("strIngredient9")
            val ingredient10 = meal.getString("strIngredient10")
            val ingredient11 = meal.getString("strIngredient11")
            val ingredient12 = meal.getString("strIngredient12")
            val ingredient13 = meal.getString("strIngredient13")
            val ingredient14 = meal.getString("strIngredient14")
            val ingredient15 = meal.getString("strIngredient15")
            val ingredient16 = meal.getString("strIngredient16")
            val ingredient17 = meal.getString("strIngredient17")
            val ingredient18 = meal.getString("strIngredient18")
            val ingredient19 = meal.getString("strIngredient19")
            val ingredient20 = meal.getString("strIngredient20")
            val measure1 = meal.getString("strMeasure1")
            val measure2 = meal.getString("strMeasure2")
            val measure3 = meal.getString("strMeasure3")
            val measure4 = meal.getString("strMeasure4")
            val measure5 = meal.getString("strMeasure5")
            val measure6 = meal.getString("strMeasure6")
            val measure7 = meal.getString("strMeasure7")
            val measure8 = meal.getString("strMeasure8")
            val measure9 = meal.getString("strMeasure9")
            val measure10 = meal.getString("strMeasure10")
            val measure11 = meal.getString("strMeasure11")
            val measure12 = meal.getString("strMeasure12")
            val measure13 = meal.getString("strMeasure13")
            val measure14 = meal.getString("strMeasure14")
            val measure15 = meal.getString("strMeasure15")
            val measure16 = meal.getString("strMeasure16")
            val measure17 = meal.getString("strMeasure17")
            val measure18 = meal.getString("strMeasure18")
            val measure19 = meal.getString("strMeasure19")
            val measure20 = meal.getString("strMeasure20")
            val source = meal.getString("strSource")
            val imageSource = meal.getString("strImageSource")
            val creativeCommonsConfirmed = meal.getString("strCreativeCommonsConfirmed")
            val dateModified = meal.getString("dateModified")



            val newMeal = Meal(name,
                drinkAlternate,
                category,
                area,
                instructions,
                mealThumb,
                tags,
                youtube,
                ingredient1, ingredient2, ingredient3, ingredient4,ingredient5, ingredient6, ingredient7, ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13, ingredient14, ingredient15, ingredient16, ingredient17, ingredient18,ingredient19, ingredient20,
                measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8, measure9, measure10, measure11, measure12, measure13, measure14, measure15, measure16, measure17, measure18, measure19, measure20,
                source, imageSource, creativeCommonsConfirmed, dateModified)
            mealList.add(newMeal)
        }
        return mealList
    }
}