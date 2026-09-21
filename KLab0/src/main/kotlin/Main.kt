import java.io.PrintStream
import kotlin.math.sqrt

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    print("Выберите номер задания (1, 2, 3, 4, 5, 6, 7): ")
    val choice = readln().toIntOrNull()

    when (choice) {
        1 -> task1()
        2 -> task2()
        3 -> task3()
        4 -> task4()
        5 -> task5()
        6 -> task6()
        7 -> task7()
        else -> println("Неверный номер задания.")
    }
}

fun task1() {
    print("Введите положительное целое число: ")
    val input = readln()
    val number = input.toInt()

    if (number <= 0) {
        println("Число должно быть положительным.")
        return
    }

    val firstDigit = input.first().digitToInt()
    val lastDigit = input.last().digitToInt()
    val summa = firstDigit + lastDigit

    println("Первая цифра: $firstDigit")
    println("Последняя цифра: $lastDigit")
    println("Сумма: $summa")
}

fun task2() {
    println("Вводите числа (для завершения введите 0):")

    var count = 0
    var summaq = 0.0

    while (true) {
        val input = readln()
        val number = input.toDouble()

        if (number == 0.0) {
            break
        }

        summaq += number
        ++count
    }

    if (count > 0) {
        val average = summaq / count
        println("Количество: $count")
        println("Сумма: $summaq")
        println("Среднее арифметическое: $average")
    } else {
        println("Числа не были введены.")
    }
}

fun task3() {
    val a = (0..10).random()
    println("Угадайте число от 0 до 10")

    while (true) {
        print("Введите ваше число: ")
        val b = readln().toInt()

        if (b > a) {
            println("Много")
        } else if (b < a) {
            println("Мало")
        } else {
            println("Угадал!")
            break
        }
    }
}

fun task4() {
    print("Введите n: ")
    val n = readln().toInt()

    var count = 0
    var current = 2

    while (count < n) {
        // Проверяем, простое ли число current
        var isPrime = true
        for (i in 2 until current) {
            if (current % i == 0) {
                isPrime = false
                break
            }
        }

        if (isPrime) {
            println(current)
            ++count
        }

        ++current
    }
}

// --- TASK 5 ---
fun task5() {
    print("Введите размер массива: ")
    val size = readln().toInt()

    if (size < 3) {
        println("Для проверки соседей нужно минимум 3 элемента.")
        return
    }

    val arr = Array(size) { 0 }

    println("Введите элементы массива (по одному на строке):")
    var input = 0
    while (input < size) {
        arr[input] = readln().toInt()
        ++input
    }

    println("Через цикл for:")
    for (indexI in 1 until arr.size - 1) {
        if (arr[indexI] > arr[indexI - 1] && arr[indexI] > arr[indexI + 1]) {
            println(arr[indexI])
        }
    }

    println("Через цикл while:")
    var indexI = 1
    while (indexI < arr.size - 1) {
        if (arr[indexI] > arr[indexI - 1] && arr[indexI] > arr[indexI + 1]) {
            println(arr[indexI])
        }
        ++indexI
    }

    println("Через функцию forEach:")
    arr.forEachIndexed { indexI, valueV ->
        if (indexI > 0 && indexI < arr.size - 1) {
            if (valueV > arr[indexI - 1] && valueV > arr[indexI + 1]) {
                println(valueV)
            }
        }
    }
}

fun task6() {
    print("Введите размер массива: ")
    val size = readln().toInt()

    if (size <= 0) {
        println("Массив не может быть пустым.")
        return
    }

    val arr = Array(size) { 0 }

    println("Введите элементы массива (по одному на строке):")
    var inputIndex = 0
    while (inputIndex < size) {
        arr[inputIndex] = readln().toInt()
        ++inputIndex
    }

    var prodFor = 1L
    var minFor = arr[0]
    var maxFor = arr[0]
    for (itemVal in arr) {
        prodFor *= itemVal
        if (itemVal < minFor) minFor = itemVal
        if (itemVal > maxFor) maxFor = itemVal
    }
    println("\nЧерез цикл for:")
    println("Произведение: $prodFor, минимум: $minFor, максимум: $maxFor")

    var prodWhile = 1L
    var minWhile = arr[0]
    var maxWhile = arr[0]
    var indexI = 0
    while (indexI < arr.size) {
        val currentVal = arr[indexI]
        prodWhile *= currentVal
        if (currentVal < minWhile) minWhile = currentVal
        if (currentVal > maxWhile) maxWhile = currentVal
        ++indexI
    }
    println("\nЧерез цикл while:")
    println("Произведение: $prodWhile, минимум: $minWhile, максимум: $maxWhile")

    var prodEach = 1L
    var minEach = arr[0]
    var maxEach = arr[0]
    arr.forEach { itemVal ->
        prodEach *= itemVal
        if (itemVal < minEach) minEach = itemVal
        if (itemVal > maxEach) maxEach = itemVal
    }
    println("\nЧерез функцию forEach:")
    println("Произведение: $prodEach, минимум: $minEach, максимум: $maxEach")

    val prodReduce = arr.map { it.toLong() }.reduce { accVal, nextVal -> accVal * nextVal }
    val minReduce = arr.reduce { accVal, nextVal -> if (nextVal < accVal) nextVal else accVal }
    val maxReduce = arr.reduce { accVal, nextVal -> if (nextVal > accVal) nextVal else accVal }
    println("\nЧерез функцию reduce:")
    println("Произведение: $prodReduce, минимум: $minReduce, максимум: $maxReduce")

    val minBuiltIn = arr.minOrNull()
    val maxBuiltIn = arr.maxOrNull()
    println("Встроенные функции:")
    println("Минимум: $minBuiltIn, максимум: $maxBuiltIn")
}

fun task7() {
    print("Введите коэффициент a: ")
    val coefA = readln().toDouble()

    print("Введите коэффициент b: ")
    val coefB = readln().toDouble()

    print("Введите коэффициент c: ")
    val coefC = readln().toDouble()

    if (coefA == 0.0) {
        // Случай линейного уравнения bx + c = 0
        if (coefB == 0.0) {
            if (coefC == 0.0) {
                println("Бесконечно много решений.")
            } else {
                println("Решений нет.")
            }
        } else {
            val rootX = -coefC / coefB
            println("Уравнение линейное. Корень x = $rootX")
        }
        return
    }

    val discriminantD = coefB * coefB - 4.0 * coefA * coefC
    println("Дискриминант D = $discriminantD")

    if (discriminantD > 0.0) {
        val rootX1 = (-coefB + sqrt(discriminantD)) / (2.0 * coefA)
        val rootX2 = (-coefB - sqrt(discriminantD)) / (2.0 * coefA)
        println("Два корня:")
        println("x1 = $rootX1")
        println("x2 = $rootX2")
    } else if (discriminantD == 0.0) {
        val rootX = -coefB / (2.0 * coefA)
        println("Один корень:")
        println("x = $rootX")
    } else {
        println("Действительных корней нет (D < 0).")
    }
}