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

    @ColumnInfo(name = "ingredient_11")
    val ingredient11: String,

    @ColumnInfo(name = "ingredient_12")
    val ingredient12: String,

    @ColumnInfo(name = "ingredient_13")
    val ingredient13: String,

    @ColumnInfo(name = "ingredient_14")
    val ingredient14: String,

    @ColumnInfo(name = "ingredient_15")
    val ingredient15: String,

    @ColumnInfo(name = "ingredient_16")
    val ingredient16: String,

    @ColumnInfo(name = "ingredient_17")
    val ingredient17: String,

    @ColumnInfo(name = "ingredient_18")
    val ingredient18: String,

    @ColumnInfo(name = "ingredient_19")
    val ingredient19: String,

    @ColumnInfo(name = "ingredient_20")
    val ingredient20: String,

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

    @ColumnInfo(name = "measure_11")
    val measure11: String,

    @ColumnInfo(name = "measure_12")
    val measure12: String,

    @ColumnInfo(name = "measure_13")
    val measure13: String,

    @ColumnInfo(name = "measure_14")
    val measure14: String,

    @ColumnInfo(name = "measure_15")
    val measure15: String,

    @ColumnInfo(name = "measure_16")
    val measure16: String,

    @ColumnInfo(name = "measure_17")
    val measure17: String,

    @ColumnInfo(name = "measure_18")
    val measure18: String,

    @ColumnInfo(name = "measure_19")
    val measure19: String,

    @ColumnInfo(name = "measure_20")
    val measure20: String,

    @ColumnInfo(name = "source")
    val source: String,

    @ColumnInfo(name = "image_source")
    val imageSource: String?,

    @ColumnInfo(name = "creative_commons_confirmed")
    val creativeCommonsConfirmed: String?,

    @ColumnInfo(name = "date_modified")
    val dateModified: String?
)
{
    constructor(meal: String,
                drinkAlternate: String?,
                category: String,
                area: String,
                instructions: String,
                mealThumb: String,
                tags: String?,
                youTube:String,
                ingredient1: String,
                ingredient2: String,
                ingredient3: String,
                ingredient4: String,
                ingredient5: String,
                ingredient6: String,
                ingredient7: String,
                ingredient8: String,
                ingredient9: String,
                ingredient10: String,
                ingredient11: String,
                ingredient12: String,
                ingredient13: String,
                ingredient14: String,
                ingredient15: String,
                ingredient16: String,
                ingredient17: String,
                ingredient18: String,
                ingredient19: String,
                ingredient20: String,
                measure1: String,
                measure2: String,
                measure3: String,
                measure4: String,
                measure5: String,
                measure6: String,
                measure7: String,
                measure8: String,
                measure9: String,
                measure10: String,
                measure11: String,
                measure12: String,
                measure13: String,
                measure14: String,
                measure15: String,
                measure16: String,
                measure17: String,
                measure18: String,
                measure19: String,
                measure20: String,
                source: String,
                imageSource: String?,
                creativeCommonsConfirmed: String?,
                dateModified: String?) :

            this(0,
                meal,
                drinkAlternate,
                category,
                area,
                instructions,
                mealThumb,
                tags,
                youTube,
                ingredient1,
                ingredient2,
                ingredient3,
                ingredient4,
                ingredient5,
                ingredient6,
                ingredient7,
                ingredient8,
                ingredient9,
                ingredient10,
                ingredient11,
                ingredient12,
                ingredient13,
                ingredient14,
                ingredient15,
                ingredient16,
                ingredient17,
                ingredient18,
                ingredient19,
                ingredient20,
                measure1,
                measure2,
                measure3,
                measure4,
                measure5,
                measure6,
                measure7,
                measure8,
                measure9,
                measure10,
                measure11,
                measure12,
                measure13,
                measure14,
                measure15,
                measure16,
                measure17,
                measure18,
                measure19,
                measure20,
                source,
                imageSource,
                creativeCommonsConfirmed,
                dateModified
            )
}