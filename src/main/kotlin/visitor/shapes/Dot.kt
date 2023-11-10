package visitor.shapes

import visitor.visitor.Visitor

open class Dot(val id: Int, val x: Int, val y: Int) : Shape {

    override fun move(x: Int, y: Int) {
        // move shape
    }

    override fun draw() {
        // draw shape
    }

    override fun accept(visitor: Visitor): String {
        return visitor.visitDot(this)
    }
}