package visitor.shapes

import visitor.visitor.Visitor

class Rectangle(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int) : Shape {

    override fun accept(visitor: Visitor): String {
        return visitor.visitRectangle(this)
    }

    override fun move(x: Int, y: Int) {
        // move shape
    }

    override fun draw() {
        // draw shape
    }
}