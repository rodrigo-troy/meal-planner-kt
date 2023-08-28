package mealplanner

fun main() {
    val mealInput = MealInput()
    val mealList = MealList()
    val mealPrinter = MealPrinter()
    var command: String?

    do {
        mealPrinter.printMenuOptions()
        command = readlnOrNull()

        when (command) {
            "add" -> {
                val category: MealCategory = mealInput.getCategory(true)
                val mealName: String = mealInput.getName(true)
                val ingredientsList: List<String> = mealInput.getIngredients(true)
                val meal = Meal(category, mealName, ingredientsList)
                mealList.addMeal(meal)
                mealPrinter.printSuccessMessage()
            }

            "show" -> {
                mealList.printMeals()
            }

            "exit" -> {
                mealPrinter.printExitMessage()
            }

            else -> {
                mealPrinter.printInvalidCommand()
            }
        }
    } while (command != "exit")
}
