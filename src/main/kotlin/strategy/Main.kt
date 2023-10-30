package strategy

import strategy.strategies.PayByCreditCard
import strategy.strategies.PayByPayPal
import strategy.strategies.PayStrategy
import strategy.order.Order
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * Стратегия — это поведенческий паттерн проектирования, который определяет семейство схожих алгоритмов и
 * помещает каждый из них в собственный класс, после чего алгоритмы можно взаимозаменять прямо во время исполнения программы.
 *
 * Стратегия — это поведенческий паттерн, выносит набор алгоритмов в собственные классы и делает их взаимозаменимыми.
 *
 * Другие объекты содержат ссылку на объект-стратегию и делегируют ей работу. Программа может подменить этот объект другим,
 * если требуется иной способ решения задачи.
 */




fun main() {
     val priceOnProducts: MutableMap<Int?, Int?> = HashMap()
     val reader = BufferedReader(InputStreamReader(System.`in`))
     var strategy: PayStrategy? = null
     val order = Order()


    priceOnProducts[1] = 2200;
    priceOnProducts[2] = 1850;
    priceOnProducts[3] = 1100;
    priceOnProducts[4] = 890;

    while (!order.isClosed) {
        var cost: Int
        var continueChoice: String
        do {
            print(
                "Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n"
            )
            val choice = reader.readLine().toInt()
            cost = priceOnProducts[choice]!!
            print("Count: ")
            val count = reader.readLine().toInt()
            order.totalCost = cost * count
            print("Do you wish to continue selecting products? Y/N: ")
            continueChoice = reader.readLine()
        } while (continueChoice.equals("Y", ignoreCase = true))
        if (strategy == null) {
            println(
                ("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card")
            )
            val paymentMethod = reader.readLine()

            // Клиент создаёт различные стратегии на основании
            // пользовательских данных, конфигурации и прочих параметров.
            strategy = if ((paymentMethod == "1")) {
                PayByPayPal()
            } else {
                PayByCreditCard()
            }
        }

        // Объект заказа делегирует сбор платёжных данны стратегии, т.к.
        // только стратегии знают какие данные им нужны для приёма оплаты.
        order.processOrder(strategy)
        print("Pay " + order.totalCost + " units or Continue shopping? P/C: ")
        val proceed = reader.readLine()
        if (proceed.equals("P", ignoreCase = true)) {
            // И наконец, стратегия запускает приём платежа.
            if (strategy.pay(order.totalCost)) {
                println("Payment has been successful.")
            } else {
                println("FAIL! Please, check your data.")
            }
            order.setClosed()
        }
    }
}