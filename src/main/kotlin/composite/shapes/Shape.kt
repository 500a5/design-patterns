package composite.shapes

import java.awt.Graphics


interface Shape {
    val x: Int
    val y: Int
    val width: Int
    val height: Int
    val isSelected: Boolean
    fun move(x: Int, y: Int)
    fun isInsideBounds(x: Int, y: Int): Boolean
    fun select()
    fun unSelect()
    fun paint(graphics: Graphics)
}