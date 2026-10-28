package org.example
// Задание 2: Перечисление типов кораблей с размерами
enum class ShipType(val size: Int) {
    BATTLESHIP(4),
    CRUISER(3),
    DESTROYER(2),
    BOAT(1);
    // Задание 5 (со звездочкой): Метод isBig
    fun isBig(): Boolean {
        return size >= 3
    }
}
