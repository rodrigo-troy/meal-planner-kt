package mealplanner

/**
 * Created with IntelliJ IDEA.
$ Project: Meal Planner
 * User: rodrigotroy
 * Date: 26-08-23
 * Time: 12:29
 */
class MealPrinter {
    fun printMeal(meal: Meal) {
        println("Category: ${meal.category.printLowercase()}")
        println("Name: ${meal.name}")
        println("Ingredients:")
        meal.ingredients.forEach { println(it) }
    }

    fun printSuccessMessage() {
        println("The meal has been added!.")
    }

    fun printInvalidCommand() {

    }

    fun printInvalidCategory() {
        println(
            "Wrong meal category! Choose from: ${
                MealCategory.values().filter { it.printable }.joinToString(", ") { it.printLowercase() }
            }."
        )
    }

    fun printExitMessage() {
        println("Bye!")
    }

    fun printMenuOptions() {
        println("What would you like to do (add, show, exit)?")
    }
}
