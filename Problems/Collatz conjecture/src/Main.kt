import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    var n = scanner.nextInt()
    print("$n ")
    while (n > 1) {

        if (n % 2 == 0) {
            n /= 2
        } else {
            n = n * 3 + 1
        }

        print("$n ")
    }
}