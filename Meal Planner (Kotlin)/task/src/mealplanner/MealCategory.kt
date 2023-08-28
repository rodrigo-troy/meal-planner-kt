package mealplanner

/**
 * Created with IntelliJ IDEA.
$ Project: Meal Planner
 * User: rodrigotroy
 * Date: 27-08-23
 * Time: 21:32
 */
enum class MealCategory(val printable: Boolean) {
    BREAKFAST(true), LUNCH(true), DINNER(true), UNDEFINED(false);

    fun printLowercase(): String {
        return this.name.lowercase()
    }

    companion object {
        fun fromString(string: String): MealCategory {
            return when (string.lowercase()) {
                "breakfast" -> BREAKFAST
                "lunch" -> LUNCH
                "dinner" -> DINNER
                else -> UNDEFINED
            }
        }

        fun fromStringOrNull(string: String?): MealCategory? {
            return if (string == null) {
                null
            } else {
                fromString(string)
            }
        }

        fun printAll(): String {
            return values().filter { it.printable }.joinToString(", ") { it.printLowercase() }
        }
    }
}
