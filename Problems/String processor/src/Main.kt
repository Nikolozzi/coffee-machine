import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val firstString = scanner.next()
    val op = scanner.next()
    val secondString = scanner.next()

    println(when (op) {
        "equals" -> firstString == secondString
        "plus" -> firstString.plus(secondString)
        "endsWith" -> firstString.endsWith(secondString)
        else -> "Unknown operation"
    })
}