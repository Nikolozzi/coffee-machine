import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    var totalSum = 0
    do {
        val n = scanner.nextInt()
        totalSum += n

    } while (n != 0)

    println(totalSum)
}