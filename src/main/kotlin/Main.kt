fun main(args: Array<String>) {
    part2()
}

fun part1() {
    var sum = 0

    File("src/main/resources/Input.txt").forEachLine { it ->

        val res = it.replace("[^0-9]".toRegex(), "")
        val firstNumber = res.first().toString()
        val lastNumber = res.last().toString()

        val combined = "$firstNumber$lastNumber".toInt()

        sum += combined
    }

    println("Part 1")
    println(sum)
    println("-------------------")
}

fun part2() {
    var sum = 0

    val numbers = mapOf(
        "zero" to 0,
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    val onlyNumbers = numbers.values

    File("src/main/resources/Input.txt").forEachLine { it ->

        var lineReplaced = it

        var list = MutableList<Int>(it.length) {-1}

        //numbers.entries.forEach { entry ->
          //  lineReplaced = lineReplaced.replace(entry.key.toRegex(), entry.value.toString())
        //}

        numbers.entries.forEach { entry ->
            val check = it.indexOf(entry.key)

            if (check >= 0) {
                list[check] = entry.value
            }
        }

        onlyNumbers.forEach { entry ->
            val check = it.indexOf(entry.toString())

            if (check >= 0) {
                list[check] = entry
            }
        }

        val firstNumber = list.first { item -> item > -1 }
        val lastNumber = list.last { item -> item > -1 }

        val combined = "$firstNumber$lastNumber".toInt()

        sum += combined
    }

    println("Part 2")
    println(sum)
    println("-------------------")
}