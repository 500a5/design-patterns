package state.states

import state.ui.Player

class PlayingState internal constructor(private val player: Player) : State() {
    override fun onLock(): String {
        player.changeState(LockedState(player))
        player.setCurrentTrackAfterStop()
        return "Stop playing"
    }

    override fun onPlay(): String {
        player.changeState(ReadyState(player))
        return "Paused..."
    }

    override fun onNext(): String {
        return player.nextTrack()
    }

    override fun onPrevious(): String {
        return player.previousTrack()
    }
}