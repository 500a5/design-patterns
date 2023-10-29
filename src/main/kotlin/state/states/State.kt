package state.states

import state.ui.Player

/**
 * Общий интерфейс для всех состояний
 */
abstract class State  {
    abstract fun onLock(): String?
    abstract fun onPlay(): String?
    abstract fun onNext(): String?
    abstract fun onPrevious(): String?
}