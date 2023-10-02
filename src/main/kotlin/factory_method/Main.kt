package factory_method

import factory_method.factory.AndroidDialog
import factory_method.factory.Dialog
import factory_method.factory.IosDialog

var dialog: Dialog? = null
val os = "ios"
fun main() {
    configure()
    runBusinessLogic()
}

/**
 * Приложение создаёт определённую фабрику в зависимости от конфигурации или
 * окружения.
 */
fun configure() {
    dialog = if (os.equals("ios")) {
        IosDialog()
    } else {
        AndroidDialog()
    }
}

/**
 * Весь остальной клиентский код работает с фабрикой и продуктами только
 * через общий интерфейс, поэтому для него неважно какая фабрика была
 * создана.
 */
fun runBusinessLogic() {
    dialog?.renderWindow()
}

/**
 * Фабричный метод — это порождающий паттерн проектирования,
 * который определяет общий интерфейс для создания объектов в суперклассе,
 * позволяя подклассам изменять тип создаваемых объектов.
 */