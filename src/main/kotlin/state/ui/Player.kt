package state.ui

import state.states.ReadyState
import state.states.State


class Player {
    var state: State
    var playing = false
    private val playlist: MutableList<String> = ArrayList()
    private var currentTrack = 0

    init {
        state = ReadyState(this)
        playing = true
        for (i in 1..12) {
            playlist.add("Track $i")
        }
    }

    fun changeState(state: State) {
        this.state = state
    }


    fun startPlayback(): String {
        return "Playing " + playlist[currentTrack]
    }

    fun nextTrack(): String {
        currentTrack++
        if (currentTrack > playlist.size - 1) {
            currentTrack = 0
        }
        return "Playing " + playlist[currentTrack]
    }

    fun previousTrack(): String {
        currentTrack--
        if (currentTrack < 0) {
            currentTrack = playlist.size - 1
        }
        return "Playing " + playlist[currentTrack]
    }

    fun setCurrentTrackAfterStop() {
        currentTrack = 0
    }
}