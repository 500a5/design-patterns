package state.states

import state.ui.Player

/**
 * They can also trigger state transitions in the context.
 */
class ReadyState(private val player: Player) : State() {
    override fun onLock(): String {
        player.changeState(LockedState(player))
        return "Locked..."
    }

    override fun onPlay(): String {
        val action: String = player.startPlayback()
        player.changeState(PlayingState(player))
        return action
    }

    override fun onNext(): String {
        return "Locked..."
    }

    override fun onPrevious(): String {
        return "Locked..."
    }
}