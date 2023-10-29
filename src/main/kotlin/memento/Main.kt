package memento

import memento.editor.Editor
import memento.shapes.Circle
import memento.shapes.CompoundShape
import memento.shapes.Dot
import memento.shapes.Rectangle
import java.awt.Color

/**
 * Снимок — это поведенческий паттерн проектирования, который позволяет сохранять и
 * восстанавливать прошлые состояния объектов, не раскрывая подробностей их реализации.
 */


fun main() {
    val editor = Editor()
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