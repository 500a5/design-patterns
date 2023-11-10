package visitor.visitor

import visitor.shapes.*

class XMLExportVisitor : Visitor {
    fun export(vararg args: Shape): String {
        val sb = StringBuilder()
        sb.append("""<?xml version="1.0" encoding="utf-8"?>""")
        for (shape in args) {
            sb.append(shape.accept(this)).append("\n")
        }
        return sb.toString()
    }

    override fun visitDot(dot: Dot): String {
        return """<dot>
    <id>${dot.id}</id>
    <x>${dot.x}</x>
    <y>${dot.y}</y>
</dot>"""
    }

    override fun visitCircle(circle: Circle): String {
        return """<circle>
    <id>${circle.id}</id>
    <x>${circle.x}</x>
    <y>${circle.y}</y>
    <radius>${circle.radius}</radius>
    </circle>"""
    }

    override fun visitRectangle(rectangle: Rectangle): String {
        return """<rectangle>
    <id>${rectangle.id}</id>
    <x>${rectangle.x}</x>
    <y>${rectangle.y}</y>
    <width>${rectangle.width}</width>
    <height>${rectangle.height}</height>
</rectangle>"""
    }

    override fun visitCompoundGraphic(cg: CompoundShape): String {
        return """<compound_graphic>
   <id>${cg.id}</id>
${_visitCompoundGraphic(cg)}</compound_graphic>"""
    }

    private fun _visitCompoundGraphic(cg: CompoundShape): String {
        val sb = StringBuilder()
        for (shape in cg.children) {
            var obj: String = shape.accept(this)
            // Proper indentation for sub-objects.
            obj = """    ${obj.replace("\n", "\n    ")}"""
            sb.append(obj)
        }
        return sb.toString()
    }
}