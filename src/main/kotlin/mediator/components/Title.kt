package mediator.components

import mediator.mediator.Mediator
import java.awt.event.KeyEvent
import javax.swing.JTextField


/**
 * Конкретные компоненты никак не связаны между собой. У них есть только один
 * канал общения – через отправку уведомлений посреднику.
 */
class Title : JTextField(), Component {
    private var mediator: Mediator? = null
    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun processComponentKeyEvent(keyEvent: KeyEvent) {
        mediator?.markNote()
    }

    override fun getName(): String {
        return "Title"
    }
}