package mediator.components

import mediator.mediator.Mediator
import mediator.mediator.Note
import java.awt.event.ActionEvent

import javax.swing.JButton


/**
 * Конкретные компоненты никак не связаны между собой. У них есть только один
 * канал общения – через отправку уведомлений посреднику.
 */
class AddButton : JButton("Add"), Component {
    private var mediator: Mediator? = null


    override fun fireActionPerformed(actionEvent: ActionEvent) {
        mediator?.addNewNote(Note())
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun getName(): String {
        return "AddButton"
    }
}