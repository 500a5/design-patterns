package composite

import composite.shapes.Circle
import composite.shapes.CompoundShape
import composite.shapes.Dot
import composite.shapes.Rectangle
import composite.editor.ImageEditor
import java.awt.Color


fun main() {
    val editor = ImageEditor()
    editor.loadShapes(
        Circle(10, 10, 10, Color.BLUE),
        CompoundShape(
            Circle(110, 110, 50, Color.RED),
            Dot(160, 160, Color.RED)
        ),
        CompoundShape(
            Rectangle(250, 250, 100, 100, Color.GREEN),
            Dot(240, 240, Color.GREEN),
            Dot(240, 360, Color.GREEN),
            Dot(360, 360, Color.GREEN),
            Dot(360, 240, Color.GREEN)
        )
    )
}

/**
 * Компоновщик — это структурный паттерн, который позволяет создавать дерево объектов и работать с ним так же, как и с единичным объектом.
Компоновщик давно стал синонимом всех задач, связанных с построением дерева объектов.
Все операции компоновщика основаны на рекурсии и «суммировании» результатов на ветвях дерева.
 */