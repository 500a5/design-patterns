package command.commands

import command.editor.Editor

class CutCommand(private val editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        if (editor.textField.selectedText.isNullOrEmpty()) return false
        backup()
        val source: String = editor.textField.text
        editor.clipboard = editor.textField.selectedText
        editor.textField.text = cutString(source)
        return true
    }

    private fun cutString(source: String): String {
        val start = source.substring(0, editor.textField.selectionStart)
        val end: String = source.substring(editor.textField.selectionEnd)
        return start + end
    }
}