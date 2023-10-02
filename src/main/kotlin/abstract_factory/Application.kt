package abstract_factory

import abstract_factory.buttons.Button
import abstract_factory.checkboxes.Checkbox
import abstract_factory.factories.GUIFactory



/**
 * Код, использующий фабрику, не волнует с какой конкретно фабрикой он работает.
 * Все получатели продуктов работают с продуктами через абстрактный интерфейс.
 */
class Application ( factory: GUIFactory) {
    private var button: Button? = null
    private var checkbox: Checkbox? = null

      init {
        button = factory.createButton()
        checkbox = factory.createCheckbox()
    }

    fun paint() {
        button?.paint()
        checkbox?.paint()
    }
}