package composite.editor

import composite.shapes.CompoundShape
import composite.shapes.Shape
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.BorderFactory
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants


class ImageEditor {
    private var canvas: EditorCanvas
    private val allShapes = CompoundShape()
    constructor(){
        this.canvas = EditorCanvas()
    }
    fun loadShapes(vararg shapes: Shape) {
        allShapes.clear()
        allShapes.add(*shapes)
        canvas.refresh()
    }

    private inner class EditorCanvas : Canvas() {
        var frame: JFrame? = null

        init {
            createFrame()
            refresh()
            addMouseListener(object : MouseAdapter() {
                override fun mousePressed(e: MouseEvent) {
                    allShapes.unSelect()
                    allShapes.selectChildAt(e.getX(), e.y)
                    e.component.repaint()
                }
            })
        }

        fun createFrame() {
            frame = JFrame()
            frame!!.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            frame!!.setLocationRelativeTo(null)
            val contentPanel = JPanel()
            val padding = BorderFactory.createEmptyBorder(
                PADDING,
                PADDING,
                PADDING,
                PADDING
            )
            contentPanel.border = padding
            frame!!.contentPane = contentPanel
            frame!!.add(this)
            frame!!.isVisible = true
            frame!!.contentPane.background = Color.LIGHT_GRAY
        }

        override fun getWidth(): Int {
            return allShapes.x + allShapes.width + PADDING
        }

        override fun getHeight(): Int {
            return allShapes.y + allShapes.height + PADDING
        }

        fun refresh() {
            this.setSize(width, height)
            frame!!.pack()
        }

        override fun paint(graphics: Graphics) {
            allShapes.paint(graphics)
        }

    }

    companion object {
        private const val PADDING = 10
    }
}