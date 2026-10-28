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
        for (c in 0..9) {
            // ВАЖНО: используем .toChar() для печати
            print("${player.field()[r][c].toChar()} ")
        }
        print("  ")
        print("$r  ")
        for (c in 0..9) {
            print("${enemy.field()[r][c].toChar()} ")
        }
        println()
    }
}

fun main() {
    // --- Проверка Задания 2 (ShipType) ---
    println("--- Типы кораблей ---")
    for (type in ShipType.values()) {
        println("${type.name}: ${type.size} клетки")
    }

    // --- Проверка Задания 3 (GameState) ---
    println("\n--- Состояния игры ---")
    val currentState = GameState.PLAYER_TURN
    println("Сейчас: ${currentState.describe()}")

    // --- Проверка Задания 5 (isBig) ---
    println("\n--- Проверка размера ---")
    println("BATTLESHIP большой? ${ShipType.BATTLESHIP.isBig()}") // true
    println("BOAT большой? ${ShipType.BOAT.isBig()}")             // false

    // --- Проверка обновленного Player ---
    println("\n--- Игра ---")
    val player = Player("Вы")
    val enemy = Player("Компьютер")

    player.placeShip(3, 2)
    player.placeShip(3, 3)
    
    enemy.markShot(3, 3, true) // Попали по кораблю игрока (поставим X на поле врага для теста)
    
    printBothFields(player, enemy)
}
