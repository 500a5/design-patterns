package mediator.mediator

import mediator.components.Component
import javax.swing.ListModel


/**
 * Общий интерфейс посредников.
 */
interface Mediator {
    fun addNewNote(note: Note?)
    fun deleteNote()
    fun getInfoFromList(note: Note?)
    fun saveChanges()
    fun markNote()
    fun clear()
    fun sendToFilter(listModel: ListModel<Any>?)
    fun setElementsList(list: ListModel<Any>?)
    fun registerComponent(component: Component?)
    fun hideElements(flag: Boolean)
    fun createGUI()
}