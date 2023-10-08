package adapter.square

import kotlin.math.pow

/**
 * КвадратныеКолышки несовместимы с КруглымиОтверстиями (они остались в проекте
 * после бывших разработчиков). Но мы должны как-то интегрировать их в нашу
 * систему.
 */
class SquarePeg(val width: Double) {
    fun getSquare(): Double {
        return width.pow(2.0)
    }
}