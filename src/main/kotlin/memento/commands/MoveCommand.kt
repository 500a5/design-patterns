package memento.commands

import memento.editor.Editor

class MoveCommand(editor: Editor) : Command {
    private val editor: Editor
    private var startX = 0
    private var startY = 0
    private var endX = 0
    private var endY = 0

    init {
        this.editor = editor
    }

    override val name: String
        get() = "Move by X:" + (endX - startX) + " Y:" + (endY - startY)

    fun start(x: Int, y: Int) {
        startX = x
        startY = y
        for (child in editor.shapes.getSelected()!!) {
            child.drag()
        }
    }

    fun move(x: Int, y: Int) {
        for (child in editor.shapes.getSelected()!!) {
            child.moveTo(x - startX, y - startY)
        }
    }

    fun stop(x: Int, y: Int) {
        endX = x
        endY = y
        for (child in editor.shapes.getSelected()!!) {
            child.drop()
        }
    }

    override fun execute() {
        for (child in editor.shapes.getSelected()!!) {
            child.moveBy(endX - startX, endY - startY)
        }
    }
}