package template_method

import template_method.networks.Facebook
import template_method.networks.Network
import template_method.networks.Twitter
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/**
 * Шаблонный метод — это поведенческий паттерн проектирования, который определяет скелет алгоритма,
 * перекладывая ответственность за некоторые его шаги на подклассы. Паттерн позволяет подклассам переопределять шаги алгоритма,
 * не меняя его общей структуры.
 *
 * Признаки применения паттерна: Класс заставляет своих потомков реализовать методы-шаги, но самостоятельно реализует структуру алгоритма.
 */


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var network: Network? = null
    print("Input user name: ")
    val userName = reader.readLine()
    print("Input password: ")
    val password = reader.readLine()

    // Вводим сообщение.
    print("Input message: ")
    val message = reader.readLine()
    println(
        """
            
            Choose social network for posting message.
            1 - Facebook
            2 - Twitter
            """.trimIndent()
    )
    val choice = reader.readLine().toInt()

    // Создаем сетевые объекты и публикуем пост.
    if (choice == 1) {
        network = Facebook(userName, password)
    } else if (choice == 2) {
        network = Twitter(userName, password)
    }
    network!!.post(message)
}