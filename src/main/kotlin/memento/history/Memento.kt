package memento.history

import memento.editor.Editor

class Memento(editor: Editor) {
    private val backup: String
    private val editor: Editor

    init {
        this.editor = editor
        backup = editor.backup()
    }

    fun restore() {
        editor.restore(backup)
    }
}