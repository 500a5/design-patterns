package observer.listeners

import java.io.File

/** Интерфейс подписчиков
 *
 */
interface EventListener {
    fun update(eventType: String, file: File)
}