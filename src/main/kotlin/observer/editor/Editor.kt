package observer.editor

import observer.publisher.EventManager
import java.io.File

/**Конкретный издатель, изменение которого хотят отслеживать наблюдатели
 *
 */
class Editor {
    var events: EventManager = EventManager("open", "save")
    private var file: File? = null

    fun openFile(filePath: String) {
        file = File(filePath)
        events.notify("open", file!!)
    }

    @Throws(Exception::class)
    fun saveFile() {
        if (file != null) {
            events.notify("save", file!!)
        } else {
            throw Exception("Please open a file first.")
        }
    }
}