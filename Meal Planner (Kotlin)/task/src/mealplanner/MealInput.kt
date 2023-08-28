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
    private val mealPrinter = MealPrinter()

    fun getCategory(showPrompt: Boolean): MealCategory {
        if (showPrompt) {
            mealPrinter.printCategoryPrompt()
        }

        val categoryInput = readlnOrNull() ?: ""

        return when (categoryInput.lowercase(Locale.getDefault())) {
            "breakfast" -> MealCategory.BREAKFAST
            "lunch" -> MealCategory.LUNCH
            "dinner" -> MealCategory.DINNER
            else -> {
                mealPrinter.printInvalidCategory()
                this.getCategory(false)
            }
        }
    }

    fun getName(showPrompt: Boolean): String {
        if (showPrompt) {
            mealPrinter.printNamePrompt()
        }

        val nameInput = readlnOrNull() ?: ""
        return if (nameInput.trim().matches(Regex("^[A-Za-z][A-Za-z\\s]*$"))) {
            nameInput
        } else {
            println("Wrong format. Use letters only!")
            this.getName(false)
        }
    }

    fun getIngredients(showPrompt: Boolean): List<String> {
        if (showPrompt) {
            println("Input the ingredients:")
        }

        val ingredientsInput = readlnOrNull() ?: ""
        val map = ingredientsInput.split(",").map { it.trim() }

        val regex = Regex("^[A-Za-z][A-Za-z\\s]*$")

        if (map.all { it.matches(regex) }) {
            return map
        } else {
            println("Wrong format. Use letters only!")
            return this.getIngredients(false)
        }

        return map
    }
}
