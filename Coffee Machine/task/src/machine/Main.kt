package machine

import java.util.*

enum class CoffeeType(val coffeeName: String, val water: Int, val coffeeBeans: Int, val cost: Int, val milk: Int = 0) {
    ESPRESSO("espresso", 250, 16, 4),
    LATTE("latte", 350, 20, 7, 75),
    CAPPUCCINO("cappuccino", 200, 12, 6, 100)
}

enum class ActionType(val actionName: String) {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit"),
    BACK("back")
}

class CoffeeMachine(private var water: Int = 400, private var milk: Int = 540, private var coffeeBeans: Int = 120,
                    private var cups: Int = 9, private var money: Int = 550) {

    companion object {
        private val scanner = Scanner(System.`in`)
    }

    fun start() {
        while (true) {
            println("Write action (${ActionType.BUY.actionName}, ${ActionType.FILL.actionName}, " +
                    "${ActionType.TAKE.actionName}, ${ActionType.REMAINING.actionName}, ${ActionType.EXIT.actionName}): > ")

            when (scanner.next()) {
                ActionType.BUY.actionName -> buy()
                ActionType.FILL.actionName -> fill()
                ActionType.TAKE.actionName -> take()
                ActionType.REMAINING.actionName -> printState()
                ActionType.EXIT.actionName -> break
            }
        }
    }

    private fun buy() {
        println("What do you want to buy? 1 - ${CoffeeType.ESPRESSO.coffeeName}, 2 - ${CoffeeType.LATTE.coffeeName}, " + "" +
                "3 - ${CoffeeType.CAPPUCCINO.coffeeName}, ${ActionType.BACK.actionName} - to main menu: > ")
        when (scanner.next()) {
            ActionType.BACK.actionName -> return
            "1" -> prepare(CoffeeType.ESPRESSO)
            "2" -> prepare(CoffeeType.LATTE)
            "3" -> prepare(CoffeeType.CAPPUCCINO)
        }
    }

    private fun prepare(coffee: CoffeeType) {
        when {
            water < coffee.water -> println("Sorry, not enough water!")
            coffeeBeans < coffee.coffeeBeans -> println("Sorry, not enough coffee beans!")
            milk < coffee.milk -> println("Sorry, not enough milk!")
            cups == 0 -> println("Sorry, not enough cups!")
            else -> {
                println("I have enough resources, making you a coffee!")

                water -= coffee.water
                coffeeBeans -= coffee.coffeeBeans
                milk -= coffee.milk
                cups -= 1
                money += coffee.cost
            }
        }
    }

    private fun fill() {
        println("Write how many ml of water do you want to add: > ")
        val water = scanner.nextInt()
        println("Write how many ml of milk do you want to add: > ")
        val milk = scanner.nextInt()
        println("Write how many grams of coffee beans do you want to add: > ")
        val coffeeBeans = scanner.nextInt()
        println("Write how many disposable cups of coffee do you want to add: > ")
        val cups = scanner.nextInt()

        this.water += water
        this.milk += milk
        this.coffeeBeans += coffeeBeans
        this.cups += cups
    }

    private fun take() {
        println("I gave you $$money")
        money = 0
    }

    private fun printState() {
        println("""
            The coffee machine has:
            $water of water
            $milk of milk
            $coffeeBeans of coffee beans
            $cups of disposable cups
            $$money of money
        """.trimIndent())
    }
}

fun main() {
    val machine = CoffeeMachine()
    machine.start()
}