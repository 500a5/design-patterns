package strategy.strategies

/**
 * Общий интерфейс всех стратегий.
 */
interface PayStrategy {
    fun pay(paymentAmount: Int): Boolean
    fun collectPaymentDetails()
}