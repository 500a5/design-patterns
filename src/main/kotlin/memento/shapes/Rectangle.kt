package memento.shapes

import memento.shapes.BaseShape
import java.awt.Color
import java.awt.Graphics


class Rectangle(x: Int, y: Int, override var width: Int, override var height: Int, color: Color) : BaseShape(x, y, color) {

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawRect(x, y, width - 1, height - 1)
    }

    override fun setColor(color: Color?) {
        TODO("Not yet implemented")
    }

    override fun drag() {
        TODO("Not yet implemented")
    }

    override fun moveTo(x: Int, y: Int) {
        TODO("Not yet implemented")
    }

    override fun moveBy(x: Int, y: Int) {
        TODO("Not yet implemented")
    }
}