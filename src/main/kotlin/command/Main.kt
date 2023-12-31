package command

import command.editor.Editor

/**
 * Команда — это поведенческий паттерн проектирования, который превращает запросы в объекты,
 * позволяя передавать их как аргументы при вызове методов, ставить запросы в очередь, логировать их,
 * а также поддерживать отмену операций.
 *
 * Команда — это поведенческий паттерн, позволяющий заворачивать запросы или простые операции в отдельные объекты.
 * Это позволяет откладывать выполнение команд, выстраивать их в очереди, а также хранить историю и делать отмену.
 */


fun main() {
    val editor = Editor()
    editor.init()
}