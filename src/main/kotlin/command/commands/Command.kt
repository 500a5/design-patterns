package command.commands

import command.editor.Editor

abstract class Command(private val editor: Editor) {

    private var backup: String? = null

    fun backup() {
        backup = editor.textField.text
    }

    fun undo() {
        editor.textField.text = backup
    }

    abstract fun execute(): Boolean
}