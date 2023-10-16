package flyweight

import flyweight.forest.Forest
import java.awt.Color
import kotlin.math.floor


var CANVAS_SIZE = 500
var TREES_TO_DRAW = 1000000
var TREE_TYPES = 2

fun main() {
    val forest = Forest()
    var i = 0
    while (i < floor((TREES_TO_DRAW / TREE_TYPES).toDouble())) {
        forest.plantTree(
            random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
            "Summer Oak", Color.GREEN, "Oak texture stub"
        )
        forest.plantTree(
            random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
            "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub"
        )
        i++
    }
    forest.setSize(CANVAS_SIZE, CANVAS_SIZE)
    forest.isVisible = true
    println("$TREES_TO_DRAW trees drawn")
    println("---------------------")
    println("Memory usage:")
    println("Tree size (8 bytes) * $TREES_TO_DRAW")
    println("+ TreeTypes size (~30 bytes) * $TREE_TYPES")
    println("---------------------")
    println(
        "Total: " + (TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024 +
                "MB (instead of " + TREES_TO_DRAW * 38 / 1024 / 1024 + "MB)"
    )
}

private fun random(min: Int, max: Int): Int {
    return min + (Math.random() * ((max - min) + 1)).toInt()
}
/**
 * Легковес — это структурный паттерн проектирования, который позволяет вместить бóльшее количество объектов в отведённую оперативную память.
 * Легковес экономит память, разделяя общее состояние объектов между собой, вместо хранения одинаковых данных в каждом объекте.
 *
 * Паттерн Легковес предлагает не хранить в классе внешнее состояние, а передавать его в те или иные методы через параметры.
 * Таким образом, одни и те же объекты можно будет повторно использовать в различных контекстах.
 * Но главное — понадобится гораздо меньше объектов, ведь теперь они будут отличаться только внутренним состоянием, а оно имеет не так много вариаций.
 * Применимость: Весь смысл использования Легковеса — в экономии памяти. Поэтому, если в приложении нет такой проблемы, то вы вряд ли найдёте там примеры Легковеса.
 */