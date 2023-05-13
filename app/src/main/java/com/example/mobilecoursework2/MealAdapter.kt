package com.example.mobilecoursework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.graphics.drawable.BitmapDrawable
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

import org.w3c.dom.Text

class MealAdapter : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    private var mealList: ArrayList<Meal> = ArrayList()

    fun addItems(items: ArrayList<Meal>){
        this.mealList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MealViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.meal_card, parent, false)
    )

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
       val meal = mealList[position]
        holder.bindView(meal, holder)
    }

    class MealViewHolder(var view: View): RecyclerView.ViewHolder(view){
        private var name = view.findViewById<TextView>(R.id.txtMealName)
        private var mealImage = view.findViewById<ImageView>(R.id.imgMeal)
        private var drinkAlternate = view.findViewById<TextView>(R.id.contDrinKAlternate)
        private var category = view.findViewById<TextView>(R.id.contCategory)
        private var area = view.findViewById<TextView>(R.id.contArea)
        private var instructions = view.findViewById<TextView>(R.id.contInstructions)
        private var tags = view.findViewById<TextView>(R.id.contTags)
        private var youTube = view.findViewById<TextView>(R.id.contYouTube)
        private var ingredient1 = view.findViewById<TextView>(R.id.txtIngredient1)
        private var ingredient2 = view.findViewById<TextView>(R.id.txtIngredient2)
        private var ingredient3 = view.findViewById<TextView>(R.id.txtIngredient3)
        private var ingredient4 = view.findViewById<TextView>(R.id.txtIngredient4)
        private var ingredient5 = view.findViewById<TextView>(R.id.txtIngredient5)
        private var ingredient6 = view.findViewById<TextView>(R.id.txtIngredient6)
        private var ingredient7 = view.findViewById<TextView>(R.id.txtIngredient7)
        private var ingredient8 = view.findViewById<TextView>(R.id.txtIngredient8)
        private var ingredient9 = view.findViewById<TextView>(R.id.txtIngredient9)
        private var ingredient10 = view.findViewById<TextView>(R.id.txtIngredient10)
        private var ingredient11 = view.findViewById<TextView>(R.id.txtIngredient11)
        private var ingredient12 = view.findViewById<TextView>(R.id.txtIngredient12)
        private var ingredient13 = view.findViewById<TextView>(R.id.txtIngredient13)
        private var ingredient14 = view.findViewById<TextView>(R.id.txtIngredient14)
        private var ingredient15 = view.findViewById<TextView>(R.id.txtIngredient15)
        private var ingredient16 = view.findViewById<TextView>(R.id.txtIngredient16)
        private var ingredient17 = view.findViewById<TextView>(R.id.txtIngredient17)
        private var ingredient18 = view.findViewById<TextView>(R.id.txtIngredient18)
        private var ingredient19 = view.findViewById<TextView>(R.id.txtIngredient19)
        private var ingredient20 = view.findViewById<TextView>(R.id.txtIngredient20)
        private var measure1 = view.findViewById<TextView>(R.id.txtMeasure1)
        private var measure2 = view.findViewById<TextView>(R.id.txtMeasure2)
        private var measure3 = view.findViewById<TextView>(R.id.txtMeasure3)
        private var measure4 = view.findViewById<TextView>(R.id.txtMeasure4)
        private var measure5 = view.findViewById<TextView>(R.id.txtMeasure5)
        private var measure6 = view.findViewById<TextView>(R.id.txtMeasure6)
        private var measure7 = view.findViewById<TextView>(R.id.txtMeasure7)
        private var measure8 = view.findViewById<TextView>(R.id.txtMeasure8)
        private var measure9 = view.findViewById<TextView>(R.id.txtMeasure9)
        private var measure10 = view.findViewById<TextView>(R.id.txtMeasure10)
        private var measure11 = view.findViewById<TextView>(R.id.txtMeasure11)
        private var measure12 = view.findViewById<TextView>(R.id.txtMeasure12)
        private var measure13 = view.findViewById<TextView>(R.id.txtMeasure13)
        private var measure14 = view.findViewById<TextView>(R.id.txtMeasure14)
        private var measure15 = view.findViewById<TextView>(R.id.txtMeasure15)
        private var measure16 = view.findViewById<TextView>(R.id.txtMeasure16)
        private var measure17 = view.findViewById<TextView>(R.id.txtMeasure17)
        private var measure18 = view.findViewById<TextView>(R.id.txtMeasure18)
        private var measure19 = view.findViewById<TextView>(R.id.txtMeasure19)
        private var measure20 = view.findViewById<TextView>(R.id.txtMeasure20)
        private var source = view.findViewById<TextView>(R.id.contSource)
        private var imageSource = view.findViewById<TextView>(R.id.contImageSource)
        private var creativeCommonConfirmed = view.findViewById<TextView>(R.id.contCreativeCommonsConfirmed)
        private var dateModified = view.findViewById<TextView>(R.id.contDateModified)

        private var llDrinkAlternate = view.findViewById<LinearLayout>(R.id.llDrinkAlternate)
        private var llTags = view.findViewById<LinearLayout>(R.id.llTags)
        private var llYoutube = view.findViewById<LinearLayout>(R.id.llYoutube)
        private var llSource = view.findViewById<LinearLayout>(R.id.llSource)
        private var llImageSource = view.findViewById<LinearLayout>(R.id.llImageSource)
        private var llCreativeCommons = view.findViewById<LinearLayout>(R.id.llCreativeCommons)
        private var llDateModified = view.findViewById<LinearLayout>(R.id.llDateModified)

        private var ll1 = view.findViewById<LinearLayout>(R.id.ll1)
        val llList = ArrayList<LinearLayout>()




        private fun getLinearLayoutId(index: Int): Int {
            val idString = "ll$index"
            return view.context.resources.getIdentifier(idString, "id", view.context.packageName)
        }

        fun bindView(meal: Meal, holder: MealViewHolder){
            for (i in 1..20) {
                val ll = view.findViewById<LinearLayout>(getLinearLayoutId(i))
                llList.add(ll)
            }

            name.text = meal.meal
            Glide.with(holder.mealImage.getContext())
                .load(meal.mealThumb)
                .transform(RoundedCornersTransformation(20, 0))
                .into(holder.mealImage);

            if (meal.drinkAlternate.isNullOrEmpty()) {
                llDrinkAlternate.visibility = View.GONE
            } else {
                llDrinkAlternate.visibility = View.VISIBLE
                drinkAlternate.text = meal.drinkAlternate
            }
            //drinkAlternate.text = meal.drinkAlternate
            category.text = meal.category
            area.text = meal.area
            instructions.text = meal.instructions
            if (meal.tags.isNullOrEmpty()) {
                llTags.visibility = View.GONE
            } else {
                llTags.visibility = View.VISIBLE
                tags.text = meal.tags
            }
            //tags.text = meal.tags
            if (meal.youTube.isNullOrEmpty()) {
                llYoutube.visibility = View.GONE
            } else {
                llYoutube.visibility = View.VISIBLE
                youTube.text = meal.youTube
            }
            //youTube.text = meal.youTube
//            ingredient1.text = meal.ingredient1
//            ingredient2.text = meal.ingredient2
//            ingredient3.text = meal.ingredient3
//            ingredient4.text = meal.ingredient4
//            ingredient5.text = meal.ingredient5
//            ingredient6.text = meal.ingredient6
//            ingredient7.text = meal.ingredient7
//            ingredient8.text = meal.ingredient8
//            ingredient9.text = meal.ingredient9
//            ingredient10.text = meal.ingredient10
//            ingredient11.text = meal.ingredient11
//            ingredient12.text = meal.ingredient12
//            ingredient13.text = meal.ingredient13
//            ingredient14.text = meal.ingredient14
//            ingredient15.text = meal.ingredient15
//            ingredient16.text = meal.ingredient16
//            ingredient17.text = meal.ingredient17
//            ingredient18.text = meal.ingredient18
//            ingredient19.text = meal.ingredient19
//            ingredient20.text = meal.ingredient20
            measure1.text = meal.measure1
            measure2.text = meal.measure2
            measure3.text = meal.measure3
            measure4.text = meal.measure4
            measure5.text = meal.measure5
            measure6.text = meal.measure6
            measure7.text = meal.measure7
            measure8.text = meal.measure8
            measure9.text = meal.measure9
            measure10.text = meal.measure10
            measure11.text = meal.measure11
            measure12.text = meal.measure12
            measure13.text = meal.measure13
            measure14.text = meal.measure14
            measure15.text = meal.measure15
            measure16.text = meal.measure16
            measure17.text = meal.measure17
            measure18.text = meal.measure18
            measure19.text = meal.measure19
            measure20.text = meal.measure20

            val ingredientList = listOf(
                meal.ingredient1, meal.ingredient2, meal.ingredient3, meal.ingredient4, meal.ingredient5,
                meal.ingredient6, meal.ingredient7, meal.ingredient8, meal.ingredient9, meal.ingredient10,
                meal.ingredient11, meal.ingredient12, meal.ingredient13, meal.ingredient14, meal.ingredient15,
                meal.ingredient16, meal.ingredient17, meal.ingredient18, meal.ingredient19, meal.ingredient20
            )

            val ingredientTextViews = arrayOf(
                ingredient1, ingredient2, ingredient3, ingredient4, ingredient5,
                ingredient6, ingredient7, ingredient8, ingredient9, ingredient10,
                ingredient11, ingredient12, ingredient13, ingredient14, ingredient15,
                ingredient16, ingredient17, ingredient18, ingredient19, ingredient20
            )

            for (i in ingredientList.indices) {
                val ingredient = ingredientList[i]
                val ingredientTextView = ingredientTextViews[i]
                if (ingredient.isNullOrEmpty()) {
                    ingredientTextView.visibility = View.GONE
                } else {
                    ingredientTextView.visibility = View.VISIBLE
                    ingredientTextView.text = ingredient
                }
            }

            for (i in ingredientList.indices) {
                val ingredient = ingredientList[i]
                val ingredientTextView = ingredientTextViews[i]
                val ll = holder.llList[i]
                if (ingredient.isNullOrEmpty()) {
                    ll.visibility = View.GONE
                } else {
                    ll.visibility = View.VISIBLE
                    ingredientTextView.text = ingredient

                }
            }
//            source.text = meal.source
//            imageSource.text = meal.imageSource
//            creativeCommonConfirmed.text = meal.creativeCommonsConfirmed
//            dateModified.text = meal.creativeCommonsConfirmed

            if (meal.source.isNullOrEmpty() || meal.source == "null") {
                llSource.visibility = View.GONE
            } else {
                llSource.visibility = View.VISIBLE
                source.text = meal.source
            }

            if (meal.imageSource.isNullOrEmpty() || meal.imageSource == "null") {
                llImageSource.visibility = View.GONE
            } else {
                llImageSource.visibility = View.VISIBLE
                imageSource.text = meal.imageSource
            }

            if (meal.creativeCommonsConfirmed.isNullOrEmpty() || meal.creativeCommonsConfirmed == "null") {
                llCreativeCommons.visibility = View.GONE
            } else {
                llCreativeCommons.visibility = View.VISIBLE
                creativeCommonConfirmed.text = meal.creativeCommonsConfirmed
            }

            if (meal.dateModified.isNullOrEmpty() || meal.dateModified == "null") {
                llDateModified.visibility = View.GONE
            } else {
                llDateModified.visibility = View.VISIBLE
                dateModified.text = meal.dateModified
            }
        }
    }
}