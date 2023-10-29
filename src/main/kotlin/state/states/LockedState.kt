package state.states

import state.ui.Player

/**
 * Конкретные состояния обеспечивают специальную реализацию для всех методов интерфейса.
 */
class LockedState internal constructor(private val player: Player) : State() {
    init {
        player.playing = false
    }

    override fun onLock(): String {
        return if (player.playing) {
            player.changeState(ReadyState(player))
            "Stop playing"
        } else {
            "Locked..."
        }
    }

    override fun onPlay(): String {
        player.changeState(ReadyState(player))
        return "Ready"
    }

    override fun onNext(): String {
        return "Locked..."
    }

    override fun onPrevious(): String {
        return "Locked..."
    }
}