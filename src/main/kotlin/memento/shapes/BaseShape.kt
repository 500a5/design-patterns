package memento.shapes

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D


abstract class BaseShape(override var x: Int, override var y: Int, private var color: Color) : Shape {

    override var isSelected = false
    private val dx = 0
    private  var dy = 0
    override val width: Int
        get() = 0
    override val height: Int
        get() = 0

    override fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        return x > this.x && x < (this.x + this.width) &&
                y > this.y && y < (this.y + this.height)
    }

    override fun drop() {
        x = dx
        y = dy
    }

    override fun select() {
        isSelected = true
    }

    override fun unSelect() {
        isSelected = false
    }

    fun enableSelectionStyle(graphics: Graphics) {
        graphics.color = Color.LIGHT_GRAY
        val g2 = graphics as Graphics2D
        val dash1 = floatArrayOf(2.0f)
        g2.stroke = BasicStroke(
            1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            2.0f, dash1, 0.0f
        )
    }

    fun disableSelectionStyle(graphics: Graphics) {
        graphics.color = color
        val g2 = graphics as Graphics2D
        g2.stroke = BasicStroke()
    }

    override fun paint(graphics: Graphics) {
        if (isSelected) {
            enableSelectionStyle(graphics)
        } else {
            disableSelectionStyle(graphics)
        }

    }
}