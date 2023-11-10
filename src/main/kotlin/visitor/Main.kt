package visitor

import visitor.shapes.*
import visitor.visitor.XMLExportVisitor


/**
 * Посетитель — это поведенческий паттерн проектирования, который позволяет добавлять в программу новые операции,
 * не изменяя классы объектов, над которыми эти операции могут выполняться.
 */


fun main() {
    val dot = Dot(1, 10, 55)
    val circle = Circle(2, 23, 15, 10)
    val rectangle = Rectangle(3, 10, 17, 20, 30)
    val compoundShape = CompoundShape(4)
    compoundShape.add(dot)
    compoundShape.add(circle)
    compoundShape.add(rectangle)
    val c = CompoundShape(5)
    c.add(dot)
    compoundShape.add(c)
    export(circle, compoundShape)
}

private fun export(vararg shapes: Shape) {
    val exportVisitor = XMLExportVisitor()
    println(exportVisitor.export(*shapes))
}