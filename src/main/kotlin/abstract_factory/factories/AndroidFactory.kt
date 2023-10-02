package abstract_factory.factories

import abstract_factory.buttons.AndroidButton
import abstract_factory.buttons.Button
import abstract_factory.checkboxes.AndroidCheckbox
import abstract_factory.checkboxes.Checkbox

class AndroidFactory:GUIFactory {
    override fun createButton(): Button {
        return AndroidButton()
    }

    override fun createCheckbox(): Checkbox {
        return AndroidCheckbox()
    }
}