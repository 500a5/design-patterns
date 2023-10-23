package mediator.components

import mediator.mediator.Mediator
import mediator.mediator.Note
import java.awt.event.KeyEvent
import javax.swing.DefaultListModel
import javax.swing.JTextField
import javax.swing.ListModel


/**
 * Конкретные компоненты никак не связаны между собой. У них есть только один
 * канал общения – через отправку уведомлений посреднику.
 */
class Filter : JTextField(), Component {
    private var mediator: Mediator? = null
    private var listModel: ListModel<Any>? = null
    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun processComponentKeyEvent(keyEvent: KeyEvent) {
        val start = text
        searchElements(start)
    }

    fun setList(listModel: ListModel<Any>?) {
        this.listModel = listModel
    }

    private fun searchElements(s: String) {
        if (listModel == null) {
            return
        }
        if (s == "") {
            mediator?.setElementsList(listModel)
            return
        }
        val notes: ArrayList<Note> = ArrayList<Note>()
        for (i in 0 until listModel!!.size) {
            notes.add(listModel!!.getElementAt(i) as Note)
        }
        val listModel: DefaultListModel<Any> = DefaultListModel<Any>()
        for (note in notes) {
            if (note.name.contains(s)) {
                listModel.addElement(note)
            }
        }
        mediator?.setElementsList(listModel)
    }

    override fun getName(): String {
        return "Filter"
    }
}