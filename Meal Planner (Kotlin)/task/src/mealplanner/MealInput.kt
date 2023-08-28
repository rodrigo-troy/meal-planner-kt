package mealplanner

import java.util.*

/**
 * Created with IntelliJ IDEA.
$ Project: Meal Planner
 * User: rodrigotroy
 * Date: 26-08-23
 * Time: 12:28
 */
class MealInput {
    fun getCategory(): MealCategory {
        println("Which meal do you want to add (breakfast, lunch, dinner)?")
        val categoryInput = readlnOrNull() ?: ""

        return when (categoryInput.lowercase(Locale.getDefault())) {
            "breakfast" -> MealCategory.BREAKFAST
            "lunch" -> MealCategory.LUNCH
            "dinner" -> MealCategory.DINNER
            else -> MealCategory.UNDEFINED
        }
    }

    fun getName(): String {
        println("Input the meal's name:")
        return readlnOrNull() ?: ""
    }

    fun getIngredients(): List<String> {
        println("Input the ingredients:")
        val ingredientsInput = readlnOrNull() ?: ""
        return ingredientsInput.split(",").map { it.trim() }
    }
}
