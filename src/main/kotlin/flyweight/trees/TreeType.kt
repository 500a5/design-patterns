package flyweight.trees

import java.awt.Color

import java.awt.Graphics


class TreeType(private val name: String, private val color: Color, private val otherTreeData: String) {
    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = Color.BLACK
        g.fillRect(x - 1, y, 3, 5)
        g.color = color
        g.fillOval(x - 5, y - 10, 10, 10)
    }
}