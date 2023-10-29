package memento.commands

import memento.editor.Editor
import java.awt.Color

class ColorCommand(editor: Editor, color: Color) : Command {
    private val editor: Editor
    private val color: Color

    init {
        this.editor = editor
        this.color = color
    }

    override val name: String
        get() = "Colorize: " + color.toString()

    override fun execute() {
        for (child in editor.shapes.getSelected()!!) {
            child.setColor(color)
        }
    }
}