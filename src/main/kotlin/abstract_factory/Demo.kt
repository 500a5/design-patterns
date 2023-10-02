package abstract_factory

import abstract_factory.factories.AndroidFactory
import abstract_factory.factories.GUIFactory
import abstract_factory.factories.IosFactory


class Demo {
    /**
     * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
     * из конфигурации или окружения.
     */
    private fun configureApplication(): Application {
        val app: Application
        val factory: GUIFactory
        val os = "ios"
        factory = if (os.contains("ios")) IosFactory() else AndroidFactory()
        app = Application(factory)
        return app
    }

    fun main() {
        val app = configureApplication()
        app.paint()
    }

}

fun main() {
    Demo().main()
}