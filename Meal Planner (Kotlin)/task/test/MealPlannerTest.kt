import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram

class MealPlannerTest : StageTest<Any>() {

    @DynamicTest
    fun normalExe4Test(): CheckResult {
        val co = CheckOutput()
        if (!co.start("What would you like to do (add, show, exit)?") )
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("add", "Which meal do you want to add (breakfast, lunch, dinner)?"))
            return CheckResult(false, "Your program should ask the user about meal category: \"(breakfast, lunch, dinner)?\"")

        if (!co.input("lunch", "Input the meal's name:"))
            return CheckResult(false, "Your output should contain \"Input the meal's name:\"")

        if (!co.input("sushi", "Input the ingredients:"))
            return CheckResult(false, "Your output should contain \"Input the ingredients:\"")

        if (!co.input("salmon, rice, avocado", "The meal has been added!"))
            return CheckResult(false, "Your output should contain \"The meal has been added!\"")

        if (!co.inputNext("What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("show", "Category: lunch", "Name: sushi", "Ingredients:",
                "salmon", "rice", "avocado"))
            return CheckResult(false, "Wrong \"show\" output for a saved meal.")

        if (!co.input("exit", "Bye!"))
            return CheckResult(false, "Your output should contain \"Bye!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun normalExe5Test(): CheckResult {
        val co = CheckOutput()
        if (!co.start("What would you like to do (add, show, exit)?") )
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("add", "Which meal do you want to add (breakfast, lunch, dinner)?"))
            return CheckResult(false, "Your program should ask the user about meal category: \"(breakfast, lunch, dinner)?\"")

        if (!co.input("lunch", "Input the meal's name:"))
            return CheckResult(false, "Your output should contain \"Input the meal's name:\"")

        if (!co.input("sushi", "Input the ingredients:"))
            return CheckResult(false, "Your output should contain \"Input the ingredients:\"")

        if (!co.input("salmon, rice, avocado", "The meal has been added!"))
            return CheckResult(false, "Your output should contain \"The meal has been added!\"")

        if (!co.inputNext("What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("add", "Which meal do you want to add (breakfast, lunch, dinner)?"))
            return CheckResult(false, "Your program should ask the user about meal category: \"(breakfast, lunch, dinner)?\"")

        if (!co.input("breakfast", "Input the meal's name:"))
            return CheckResult(false, "Your output should contain \"Input the meal's name:\"")

        if (!co.input("oatmeal", "Input the ingredients:"))
            return CheckResult(false, "Your output should contain \"Input the ingredients:\"")

        if (!co.input("oats, milk, banana, peanut butter", "The meal has been added!"))
            return CheckResult(false, "Your output should contain \"The meal has been added!\"")

        if (!co.inputNext("What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("show", "Category: lunch", "Name: sushi", "Ingredients:",
                "salmon", "rice", "avocado", "Category: breakfast", "Name: oatmeal", "Ingredients:",
                "oats", "milk", "banana", "peanut butter"))
            return CheckResult(false, "Wrong \"show\" output for 2 saved meals.")

        if (!co.input("exit", "Bye!"))
            return CheckResult(false, "Your output should contain \"Bye!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun exeWithErrors1Test(): CheckResult {
        val co = CheckOutput()
        if (!co.start("What would you like to do (add, show, exit)?") )
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("show", "No meals saved. Add a meal first."))
            return CheckResult(false, "Your output should contain \"No meals saved. Add a meal first.\"")

        if (!co.input("new meal", "What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action after a wrong command input.")

        if (!co.input("meal", "What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action after a wrong command input.")

        if (!co.input("", "What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action after a wrong command input.")

        if (!co.input(" \t", "What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action after a wrong command input.")

        if (!co.input("add", "Which meal do you want to add (breakfast, lunch, dinner)?"))
            return CheckResult(false, "Your program should ask the user about meal category: \"(breakfast, lunch, dinner)?\"")

        if (!co.input("dessert", "Wrong meal category! Choose from: breakfast, lunch, dinner."))
            return CheckResult(false, "Your output should contain \"Wrong meal category! Choose from: breakfast, lunch, dinner.\"")

        if (!co.input("nothing", "Wrong meal category! Choose from: breakfast, lunch, dinner."))
            return CheckResult(false, "Your output should contain \"Wrong meal category! Choose from: breakfast, lunch, dinner.\"")

        if (!co.input("meal1", "Wrong meal category! Choose from: breakfast, lunch, dinner."))
            return CheckResult(false, "Your output should contain \"Wrong meal category! Choose from: breakfast, lunch, dinner.\"")

        if (!co.input("meal@", "Wrong meal category! Choose from: breakfast, lunch, dinner."))
            return CheckResult(false, "Your output should contain \"Wrong meal category! Choose from: breakfast, lunch, dinner.\"")

        if (!co.input("", "Wrong meal category! Choose from: breakfast, lunch, dinner."))
            return CheckResult(false, "Your output should contain \"Wrong meal category! Choose from: breakfast, lunch, dinner.\"")

        if (!co.input(" \t", "Wrong meal category! Choose from: breakfast, lunch, dinner."))
            return CheckResult(false, "Your output should contain \"Wrong meal category! Choose from: breakfast, lunch, dinner.\"")

        if (!co.input("lunch", "Input the meal's name:"))
            return CheckResult(false, "Your output should contain \"Input the meal's name:\"")

        if (!co.input("burger1", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("sushi@", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input(" \t", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("sushi", "Input the ingredients:"))
            return CheckResult(false, "Your output should contain \"Input the ingredients:\"")

        if (!co.input("salmon, rice1, avocado", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("salmon, , avocado", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("salmon,, avocado", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("salmon, rice, ", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("salmon, rice, avocado@", "Wrong format. Use letters only!"))
            return CheckResult(false, "Your output should contain \"Wrong format. Use letters only!\"")

        if (!co.input("salmon, rice, avocado", "The meal has been added!"))
            return CheckResult(false, "Your output should contain \"The meal has been added!\"")

        if (!co.inputNext("What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("add", "Which meal do you want to add (breakfast, lunch, dinner)?"))
            return CheckResult(false, "Your program should ask the user about meal category: \"(breakfast, lunch, dinner)?\"")

        if (!co.input("breakfast", "Input the meal's name:"))
            return CheckResult(false, "Your output should contain \"Input the meal's name:\"")

        if (!co.input("oatmeal", "Input the ingredients:"))
            return CheckResult(false, "Your output should contain \"Input the ingredients:\"")

        if (!co.input("oats, milk, banana, peanut butter", "The meal has been added!"))
            return CheckResult(false, "Your output should contain \"The meal has been added!\"")

        if (!co.inputNext("What would you like to do (add, show, exit)?"))
            return CheckResult(false, "Your program should ask the user about the required action: \"(add, show, exit)?\"")

        if (!co.input("show", "Category: lunch", "Name: sushi", "Ingredients:",
                "salmon", "rice", "avocado", "Category: breakfast", "Name: oatmeal", "Ingredients:",
                "oats", "milk", "banana", "peanut butter"))
            return CheckResult(false, "Wrong \"show\" output for 2 saved meals.")

        if (!co.input("exit", "Bye!"))
            return CheckResult(false, "Your output should contain \"Category: lunch\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "Bye!")

        return CheckResult.correct()
    }

}

class CheckOutput {
    private var main: TestedProgram = TestedProgram()
    private var position = 0
    private var caseInsensitive = true
    private var trimOutput = true
    private val arguments= mutableListOf<String>()
    private var isStarted = false
    private var lastOutput = ""

    private fun checkOutput(outputString: String, vararg checkStr: String): Boolean {
        var searchPosition = position
        for (cStr in checkStr) {
            val str = if (caseInsensitive) cStr.lowercase() else cStr
            val findPosition = outputString.indexOf(str, searchPosition)
            if (findPosition == -1) return false
            if ( outputString.substring(searchPosition until findPosition).isNotBlank() ) return false
            searchPosition = findPosition + str.length
        }
        position = searchPosition
        return true
    }

    fun start(vararg checkStr: String): Boolean {
        return if (!isStarted) {
            var outputString = main.start(*arguments.toTypedArray())
            lastOutput = outputString
            if (trimOutput) outputString = outputString.trim()
            if (caseInsensitive) outputString = outputString.lowercase()
            isStarted = true
            checkOutput(outputString, *checkStr)
        } else false
    }

    fun stop() {
        main.stop()
    }

    fun input(input: String, vararg checkStr: String): Boolean {
        if (main.isFinished) return false
        var outputString = main.execute(input)
        lastOutput = outputString
        if (trimOutput) outputString = outputString.trim()
        if (caseInsensitive) outputString = outputString.lowercase()
        position = 0
        return checkOutput(outputString, *checkStr)
    }

    fun inputNext(vararg checkStr: String): Boolean {
        var outputString = lastOutput
        if (trimOutput) outputString = outputString.trim()
        if (caseInsensitive) outputString = outputString.lowercase()
        return checkOutput(outputString, *checkStr)
    }

    fun getNextOutput(input: String): String {
        if (main.isFinished) return ""
        val outputString = main.execute(input)
        lastOutput = outputString
        position = 0
        return  outputString
    }

    fun getLastOutput(): String { return lastOutput }
    fun programIsFinished(): Boolean  = main.isFinished
    fun setArguments(vararg args: String) { arguments.addAll(args.toMutableList()) }
    fun setCaseSensitivity(caseInsensitive: Boolean) { this.caseInsensitive = caseInsensitive }
    fun setOutputTrim(trimOutput: Boolean) { this.trimOutput = trimOutput}
}


