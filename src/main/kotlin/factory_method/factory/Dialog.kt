package factory_method.factory

import factory_method.buttons.Button

/**
 * Базовый класс фабрики. Заметьте, что "фабрика" – это всего лишь
 * дополнительная роль для класса. Он уже имеет какую-то бизнес-логику, в
 * которой требуется создание разнообразных продуктов.
 */
abstract class Dialog {
    fun renderWindow(){
        val btn = createButton()
        btn.render()
    }

    abstract fun createButton(): Button
}