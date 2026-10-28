package org.example

fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===   === Поле игрока ${enemy.name} ===")
    print("   ")
    for (c in 0..9) print("$c ")
    print("  ")
    print("   ")
    for (c in 0..9) print("$c ")
    println()

    for (r in 0..9) {
        print("$r  ")
        for (c in 0..9) print("${player.field()[r][c]} ")
        
        print("  ")
        
        print("$r  ")
        for (c in 0..9) print("${enemy.field()[r][c]} ")
        println()
    }
}

fun main() {
    val player = Player("Вы")
    val enemy = Player("Компьютер")

    player.placeShip(3, 2)
    player.placeShip(3, 3)
    player.placeShip(3, 4)
    player.placeShip(3, 5)

    enemy.placeShip(5, 7)
    enemy.placeShip(6, 7)
    enemy.placeShip(7, 7)

    // Печатаем поля
    printBothFields(player, enemy)
    println()

    // Проверяем registerShot
    player.registerShot(true)    // попал
    player.registerShot(false)   // промах
    player.registerShot(true)    // попал

    println(player.status())
    // Ожидается: Игрок Вы: выстрелов 3, попаданий 2, точность 66.7%

    println("Выстрелов: ${player.shots}")
    println("Попаданий: ${player.hits}")

    // Проверяем reset
    player.reset()
    println(player.status())
    // Ожидается: Игрок Вы: выстрелов 0, попаданий 0, точность 0.0%
    
    println("\n--- Проверка markShot (Задание 6) ---")
    enemy.markShot(3, 3, true)  // Попадание (X)
    enemy.markShot(4, 4, false) // Промах (O)
    enemy.markShot(9, 9, true)  // Попадание на краю (X)
    println("Смотрим на поле противника (там должны быть X и O):")
    
    // Выведем только поле противника для проверки
    println("=== Поле ${enemy.name} ===")
    print("   ")
    for (c in 0..9) print("$c ")
    println()
    for (r in 0..9) {
        print("$r  ")
        for (c in 0..9) print("${enemy.field()[r][c]} ")
        println()
    }
}
