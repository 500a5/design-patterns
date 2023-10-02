package abstract_factory.factories

import abstract_factory.buttons.Button
import abstract_factory.buttons.IosButton
import abstract_factory.checkboxes.Checkbox
import abstract_factory.checkboxes.IosCheckbox

class IosFactory:GUIFactory {
    override fun createButton(): Button {
        return IosButton()
    }

    override fun createCheckbox(): Checkbox {
        return IosCheckbox()
    }

}