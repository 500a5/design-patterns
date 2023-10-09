package composite.shapes

import java.awt.Color
import java.awt.Graphics


class Dot(x: Int, y: Int, color: Color) : BaseShape(x, y, color) {
    override val height = 3

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.fillRect(x - 1, y - 1, height, height)
    }
}