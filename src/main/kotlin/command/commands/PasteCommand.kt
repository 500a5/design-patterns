package command.commands

import command.editor.Editor

class PasteCommand(private val editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        if (editor.clipboard.isNullOrEmpty()) return false
        backup()
        editor.textField.insert(editor.clipboard, editor.textField.caretPosition)
        return true
    }
}