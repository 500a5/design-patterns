package observer.publisher

import observer.listeners.EventListener
import java.io.File

/**Базовый издатель
 *
 */
class EventManager(vararg operations: String) {
    private var listeners: MutableMap<String, MutableList<EventListener>> = HashMap()

    init {
        for (operation in operations) {
            listeners[operation] = ArrayList()
        }
    }

    fun subscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType]!!
        users.add(listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType]!!
        users.remove(listener)
    }

    fun notify(eventType: String, file: File) {
        val users: List<EventListener> = listeners[eventType]!!
        for (listener in users) {
            listener.update(eventType, file)
        }
    }
}