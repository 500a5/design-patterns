package command.commands

import java.util.*

class CommandHistory {
    private val history: Stack<Command> = Stack()
    fun push(c: Command?) {
        history.push(c)
    }

    fun pop(): Command {
        return history.pop()
    }

    val isEmpty: Boolean
        get() = history.isEmpty()
}