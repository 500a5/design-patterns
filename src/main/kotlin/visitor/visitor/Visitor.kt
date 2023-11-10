package visitor.visitor

import visitor.shapes.Circle
import visitor.shapes.CompoundShape
import visitor.shapes.Dot
import visitor.shapes.Rectangle


interface Visitor {
    fun visitDot(dot: Dot): String
    fun visitCircle(circle: Circle): String
    fun visitRectangle(rectangle: Rectangle): String
    fun visitCompoundGraphic(cg: CompoundShape): String
}