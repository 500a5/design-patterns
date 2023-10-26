package observer

import observer.editor.Editor
import observer.listeners.EmailNotificationListener
import observer.listeners.LogOpenListener


/**
Наблюдатель — это поведенческий паттерн проектирования, который создаёт механизм подписки,
позволяющий одним объектам следить и реагировать на события, происходящие в других объектах.
 */

fun main() {
    val editor = Editor()
    editor.events.subscribe("open", LogOpenListener("/path/to/log/file.txt"))
    editor.events.subscribe("save", EmailNotificationListener("admin@example.com"))
    try {
        editor.openFile("test.txt")
        editor.saveFile()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}