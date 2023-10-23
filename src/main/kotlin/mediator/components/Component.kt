package mediator.components

import mediator.mediator.Mediator

/**
 * Общий интерфейс компонентов.
 */
interface Component {
    fun setMediator(mediator: Mediator)
    fun getName(): String?
}