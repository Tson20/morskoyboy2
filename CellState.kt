package org.example
// Задание 1: Перечисление состояний клетки
enum class CellState {
    EMPTY,
    SHIP,
    HIT,
    MISS;
    // Метод для преобразования в символ для печати
    fun toChar(): Char {
        return when (this) {
            CellState.EMPTY -> '.'
            CellState.SHIP -> '#'
            CellState.HIT -> 'X'
            CellState.MISS -> 'O'
        }
    }
}
