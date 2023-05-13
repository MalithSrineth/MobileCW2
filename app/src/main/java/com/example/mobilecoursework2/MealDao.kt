package com.example.mobilecoursework2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDao {
    @Insert
    fun insert(meal: Meal)

    @Query("SELECT * FROM meals")
    fun getAll(): List<Meal>

    @Query("DELETE FROM meals")
    fun clear()

    @Query("DELETE FROM sqlite_sequence WHERE name='meals'")
    fun resetPrimaryKey()

    @Query("SELECT meal FROM meals")
    fun getAllMealNames(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(meals: List<Meal>)
}