package mediator

import mediator.components.*
import mediator.components.List
import mediator.mediator.Editor
import mediator.mediator.Mediator
import javax.swing.DefaultListModel


/**
 * Посредник — это поведенческий паттерн проектирования, который позволяет уменьшить связанность множества классов между собой,
 * благодаря перемещению этих связей в один класс-посредник.
 *
 * Посредник — это поведенческий паттерн, который упрощает коммуникацию между компонентами системы.
 *
 * Посредник убирает прямые связи между отдельными компонентами, заставляя их общаться друг с другом через себя.
 */


fun main() {
    val mediator: Mediator = Editor()
    mediator.registerComponent(Title())
    mediator.registerComponent(TextBox())
    mediator.registerComponent(AddButton())
    mediator.registerComponent(DeleteButton())
    mediator.registerComponent(SaveButton())
    mediator.registerComponent(List(DefaultListModel <Any> ()))
    mediator.registerComponent(Filter())
    mediator.createGUI()
}