package mealplanner

fun main() {
    val mealInput = MealInput()
    val category = mealInput.getCategory()
    val mealName = mealInput.getName()
    val ingredientsList = mealInput.getIngredients()

    val meal = Meal(category, mealName, ingredientsList)

    val mealPrinter = MealPrinter()
    mealPrinter.printMeal(meal)
    mealPrinter.printSuccessMessage()
}
