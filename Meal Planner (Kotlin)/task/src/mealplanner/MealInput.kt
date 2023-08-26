package mealplanner

/**
 * Created with IntelliJ IDEA.
$ Project: Meal Planner
 * User: rodrigotroy
 * Date: 26-08-23
 * Time: 12:28
 */
class MealInput {
    fun getCategory(): String {
        println("Which meal do you want to add (breakfast, lunch, dinner)?")
        return readlnOrNull() ?: ""
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
