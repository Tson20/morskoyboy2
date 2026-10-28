package org.example

class Player {
    var name: String = ""
    var field: Array<CharArray> = Array(10) { CharArray(10) { '.' } }

    var shots: Int = 0    // Выстрелы
    var hits: Int = 0     // Попадания
    var shipsLeft: Int = 20 // Количество неповрежденных палуб (по умолчанию 20)

    // Проверка, жив ли игрок
    fun isAlive(): Boolean {
        return shipsLeft > 0
    }

    // Вычисление точности
    fun accuracy(): Double {
        if (shots == 0) {
            return 0.0
        }
        return hits * 100.0 / shots
    }

    // Формирование красивой строки со статусом
    fun status(): String {
        // Форматируем точность до 1 знака после запятой
        val accFormatted = "%.1f".format(accuracy())
        return "Игрок $name: палуб осталось $shipsLeft, выстрелов $shots, попаданий $hits, точность $accFormatted%"
    }

    // Получение урона
    fun takeDamage(): Boolean {
        shipsLeft = shipsLeft - 1 // Уменьшаем количество палуб
        return shipsLeft > 0      // Возвращаем true, если еще живы
    }

    // Регистрация выстрела
    fun registerShot(hit: Boolean) {
        shots = shots + 1 // Увеличиваем счетчик выстрелов всегда
        if (hit == true) {
            hits = hits + 1 // Если попали, увеличиваем счетчик попаданий
        }
    }

    // Сброс игры (очистка поля и статистики)
    fun reset() {
        shots = 0
        hits = 0
        shipsLeft = 20

        // Очищаем поле: проходим по всем строкам и столбцам
        for (r in 0..9) {
            for (c in 0..9) {
                field[r][c] = '.' // Заменяем все на точки
            }
        }
    }

    // Метод для печати поля (из прошлого урока)
    fun printField() {
        println("=== Поле игрока $name ===")
        print("   ")
        for (c in 0..9) print("$c ")
        println()
        for (r in 0..9) {
            print("$r  ")
            for (c in 0..9) {
                print("${field[r][c]} ")
            }
            println()
        }
    }
}

fun main() {
    val player = Player()
    player.name = "Вы"

    // Проверяем registerShot
    player.registerShot(true)    // попал
    player.registerShot(false)   // промах
    player.registerShot(true)    // попал

    // Проверяем status
    println(player.status())
    // Ожидается: Игрок Вы: палуб осталось 20, выстрелов 3, попаданий 2, точность 66.7%

    // Проверяем takeDamage
    player.takeDamage()
    player.takeDamage()
    println("Палуб осталось: ${player.shipsLeft}") // Ожидается: 18
    println("Жив ли игрок? ${player.isAlive()}")   // Ожидается: true

    // Проверяем reset
    player.reset()
    println(player.status())
    // Ожидается: Игрок Вы: палуб осталось 20, выстрелов 0, попаданий 0, точность 0.0%

    // Проверяем, что поле действительно очистилось
    println("\nПроверка очистки поля (должны быть только точки):")
    player.field[0][0] = '#' // Сначала поставим корабль
    player.reset()           // Потом сбросим
    player.printField()      // Везде должны быть точки
}
