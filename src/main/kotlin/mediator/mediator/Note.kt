package mediator.mediator


/**
 * Класс заметок.
 */
class Note {
    var name = "New note"
    var text: String? = null

    override fun toString(): String {
        return name
    }
}