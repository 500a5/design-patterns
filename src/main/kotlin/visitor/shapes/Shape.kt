package visitor.shapes

import visitor.visitor.Visitor

interface Shape {
    fun move(x: Int, y: Int)
    fun draw()
    fun accept(visitor: Visitor): String
}