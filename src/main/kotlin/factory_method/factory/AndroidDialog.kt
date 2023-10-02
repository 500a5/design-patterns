package factory_method.factory

import factory_method.buttons.AndroidButton
import factory_method.buttons.Button

class AndroidDialog : Dialog() {
    override fun createButton(): Button {
        return AndroidButton()
    }
}