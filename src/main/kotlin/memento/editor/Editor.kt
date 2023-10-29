package memento.editor



import memento.commands.Command
import memento.history.History
import memento.history.Memento
import memento.shapes.CompoundShape
import memento.shapes.Shape
import java.io.*
import java.util.*
import javax.swing.JComponent


class Editor : JComponent() {
    private val canvas: Canvas
    var shapes = CompoundShape()
        private set
    private val history: History

    init {
        canvas = Canvas(this)
        history = History()
    }

    fun loadShapes(vararg shapes: Shape) {
        this.shapes.clear()
        this.shapes.add(*shapes)
        this.canvas.refresh()
    }

    fun execute(c: Command) {
        history.push(c, Memento(this))
        c.execute()
    }

    fun undo() {
        if (history.undo()) canvas.repaint()
    }

    fun redo() {
        if (history.redo()) canvas.repaint()
    }

    fun backup(): String {
        return try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(shapes)
            oos.close()
            Base64.getEncoder().encodeToString(baos.toByteArray())
        } catch (e: IOException) {
            ""
        }
    }

    fun restore(state: String?) {
        try {
            val data = Base64.getDecoder().decode(state)
            val ois = ObjectInputStream(ByteArrayInputStream(data))
            shapes = ois.readObject() as CompoundShape
            ois.close()
        } catch (e: ClassNotFoundException) {
            print("ClassNotFoundException occurred.")
        } catch (e: IOException) {
            print("IOException occurred.")
        }
    }

}