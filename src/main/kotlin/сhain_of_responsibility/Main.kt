package сhain_of_responsibility

import сhain_of_responsibility.middleware.Middleware
import сhain_of_responsibility.middleware.RoleCheckMiddleware
import сhain_of_responsibility.middleware.ThrottlingMiddleware
import сhain_of_responsibility.middleware.UserExistsMiddleware
import сhain_of_responsibility.server.Server
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Цепочка обязанностей — это поведенческий паттерн проектирования,
 * который позволяет передавать запросы последовательно по цепочке обработчиков.
 * Каждый последующий обработчик решает, может ли он обработать запрос сам и стоит ли передавать запрос дальше по цепи.
 *
 * Этот пример показывает как пользовательские данные проходят последовательную аутентификацию в множестве обработчиков, связанных в одну цепь.
 *
 * Этот пример отличается от канонической версии тем, что проверка обрывается, если очередной обработчик не может обработать запрос.
 * В классическом варианте, следование по цепочке заканчивается как только нашёлся элемент цепи, который может обработать запрос.
 * Просто знайте, что Концептуальный пример от этого не меняется, а код отличается только условием выхода из цепи.
 */

private val reader = BufferedReader(InputStreamReader(System.`in`))
private var server = Server()

private fun init() {
    server = Server()
    server.register("admin@example.com", "admin_pass")
    server.register("user@example.com", "user_pass")

    // Проверки связаны в одну цепь. Клиент может строить различные цепи,
    // используя одни и те же компоненты.
    val middleware = Middleware.link(
        ThrottlingMiddleware(2),
        UserExistsMiddleware(server),
        RoleCheckMiddleware()
    )

    // Сервер получает цепочку от клиентского кода.
    server.setMiddleware(middleware)
}


fun main() {
    init()
    var success: Boolean
    do {
        print("Enter email: ")
        val email = reader.readLine()
        print("Input password: ")
        val password = reader.readLine()
        success = server.logIn(email, password)
    } while (!success)
}

