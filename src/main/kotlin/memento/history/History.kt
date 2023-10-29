package memento.history

import memento.commands.Command


class History {
    private var history: MutableList<Pair> = ArrayList()
    private var virtualSize = 0

    private inner class Pair(c: Command, m: Memento) {
        var command: Command
        var memento: Memento

        init {
            command = c
            memento = m
        }

    }

    fun push(c: Command?, m: Memento?) {
        if (virtualSize != history.size && virtualSize > 0) {
            history = history.subList(0, virtualSize - 1)
        }
        history.add(this.Pair(c!!, m!!))
        virtualSize = history.size
    }

    fun undo(): Boolean {
        val pair = undo ?: return false
        System.out.println("Undoing: " + pair.command.name)
        pair.memento.restore()
        return true
    }

    fun redo(): Boolean {
        val pair = redo ?: return false
        System.out.println("Redoing: " + pair.command.name)
        pair.memento.restore()
        pair.command.execute()
        return true
    }

    private val undo: Pair?
        private get() {
            if (virtualSize == 0) {
                return null
            }
            virtualSize = Math.max(0, virtualSize - 1)
            return history[virtualSize]
        }
    private val redo: Pair?
        get() {
            if (virtualSize == history.size) {
                return null
            }
            virtualSize = Math.min(history.size, virtualSize + 1)
            return history[virtualSize - 1]
        }
}