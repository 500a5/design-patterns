package memento.shapes

import java.awt.Color
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
    fun setColor(color: Color?)
    fun drag()
    fun drop()
    fun moveTo(x: Int, y: Int)
    fun moveBy(x: Int, y: Int)
}