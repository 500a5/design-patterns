package factory_method.factory

import factory_method.buttons.Button
import factory_method.buttons.IosButton

class IosDialog : Dialog() {
    override fun createButton(): Button {
        return IosButton()
    }
}