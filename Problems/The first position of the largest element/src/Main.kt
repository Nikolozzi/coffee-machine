import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here

    var maxVal = Integer.MIN_VALUE
    var maxValInd = -1
    var i = 1
    while (scanner.hasNext()) {
        val num = scanner.nextInt()
        if (num > maxVal) {
            maxVal = num
            maxValInd = i
        }

        i++
    }

    println("$maxVal $maxValInd")
}