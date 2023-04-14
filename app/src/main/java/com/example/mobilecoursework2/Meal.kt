package com.example.mobilecoursework2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "meal")
    val meal: String,

    @ColumnInfo(name = "drink_alternate")
    val drinkAlternate: String?,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "area")
    val area: String,

    @ColumnInfo(name = "instructions")
    val instructions: String,

    @ColumnInfo(name = "meal_thumb")
    val mealThumb: String,

    @ColumnInfo(name = "tags")
    val tags: String?,

    @ColumnInfo(name = "youtube")
    val youTube:String,

    @ColumnInfo(name = "ingredient_1")
    val ingredient1: String,

    @ColumnInfo(name = "ingredient_2")
    val ingredient2: String,

    @ColumnInfo(name = "ingredient_3")
    val ingredient3: String,

    @ColumnInfo(name = "ingredient_4")
    val ingredient4: String,

    @ColumnInfo(name = "ingredient_5")
    val ingredient5: String,

    @ColumnInfo(name = "ingredient_6")
    val ingredient6: String,

    @ColumnInfo(name = "ingredient_7")
    val ingredient7: String,

    @ColumnInfo(name = "ingredient_8")
    val ingredient8: String,

    @ColumnInfo(name = "ingredient_9")
    val ingredient9: String,

    @ColumnInfo(name = "ingredient_10")
    val ingredient10: String,

    @ColumnInfo(name = "measure_1")
    val measure1: String,

    @ColumnInfo(name = "measure_2")
    val measure2: String,

    @ColumnInfo(name = "measure_3")
    val measure3: String,

    @ColumnInfo(name = "measure_4")
    val measure4: String,

    @ColumnInfo(name = "measure_5")
    val measure5: String,

    @ColumnInfo(name = "measure_6")
    val measure6: String,

    @ColumnInfo(name = "measure_7")
    val measure7: String,

    @ColumnInfo(name = "measure_8")
    val measure8: String,

    @ColumnInfo(name = "measure_9")
    val measure9: String,

    @ColumnInfo(name = "measure_10")
    val measure10: String,

    @ColumnInfo(name = "source")
    val source: String,

    @ColumnInfo(name = "image_source")
    val imageSource: String?,

    @ColumnInfo(name = "creative_commons_confirmed")
    val creativeCommonsConfirmed: String?,

    @ColumnInfo(name = "date_modified")
    val dateModified: String?
)