package strategy.strategies

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/**
 * Конкретная стратегия. Реализует оплату корзины интернет магазина кредитной
 * картой клиента.
 */
class PayByCreditCard : PayStrategy {
    private val READER = BufferedReader(InputStreamReader(System.`in`))
    private var card: CreditCard? = null

    /**
     * Собираем данные карты клиента.
     */
    override fun collectPaymentDetails() {
        try {
            print("Enter the card number: ")
            val number = READER.readLine()
            print("Enter the card expiration date 'mm/yy': ")
            val date = READER.readLine()
            print("Enter the CVV code: ")
            val cvv = READER.readLine()
            card = CreditCard(number, date, cvv)

            // Валидируем номер карты...
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    /**
     * После проверки карты мы можем совершить оплату. Если клиент продолжает
     * покупки, мы не запрашиваем карту заново.
     */
    override fun pay(paymentAmount: Int): Boolean {
        return if (cardIsPresent()) {
            println("Paying $paymentAmount using Credit Card.")
            card!!.amount -= paymentAmount
            true
        } else {
            false
        }
    }

    private fun cardIsPresent(): Boolean {
        return card != null
    }
}