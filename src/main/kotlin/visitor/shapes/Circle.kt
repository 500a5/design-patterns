package visitor.shapes

import visitor.visitor.Visitor

class Circle(id: Int, x: Int, y: Int, val radius: Int) : Dot(id, x, y) {

    override fun accept(visitor: Visitor): String {
        return visitor.visitCircle(this)
    }
}