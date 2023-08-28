package mealplanner

enum class MealCategory(val printable: Boolean) {
    BREAKFAST(true), LUNCH(true), DINNER(true), UNDEFINED(false);

    fun printLowercase(): String {
        return this.name.lowercase()
    }
}

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
                var category: MealCategory? = null
                while (category == null || !category.printable) {
                    if (category != null) {
                        mealPrinter.printInvalidCategory()
                    }

                    category = mealInput.getCategory()
                }

                var mealName: String? = null
                while (mealName == null) {
                    mealName = mealInput.getName()
                }

                var ingredientsList: List<String>? = null
                while (ingredientsList == null) {
                    ingredientsList = mealInput.getIngredients()
                }

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
