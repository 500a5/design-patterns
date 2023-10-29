package memento.shapes

import memento.shapes.BaseShape
import java.awt.Color
import java.awt.Graphics


class Dot(x: Int, y: Int, color: Color) : BaseShape(x, y, color) {
    override val height = 3

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.fillRect(x - 1, y - 1, height, height)
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