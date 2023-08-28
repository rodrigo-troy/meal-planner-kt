package mealplanner

/**
 * Created with IntelliJ IDEA.
$ Project: Meal Planner
 * User: rodrigotroy
 * Date: 27-08-23
 * Time: 21:07
 */
class MealList {
    private val meals = mutableListOf<Meal>()
    private val mealPrinter = MealPrinter()

    fun addMeal(meal: Meal) {
        meals.add(meal)
    }

    fun printMeals() {
        if (meals.isEmpty()) {
            println("No meals saved. Add a meal first.")
        } else {
            meals.forEach { meal ->
                mealPrinter.printMeal(meal)
                println()
            }
        }
    }
}
