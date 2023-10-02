package abstract_factory.factories

import abstract_factory.buttons.Button
import abstract_factory.checkboxes.Checkbox

/**
 * Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}