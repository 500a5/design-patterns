package command.commands

import command.editor.Editor

class CopyCommand(private val editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        editor.clipboard = editor.textField.selectedText
        return false
    }
}