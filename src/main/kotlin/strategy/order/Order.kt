package strategy.order

import strategy.strategies.PayStrategy


/**
 * Класс заказа. Ничего не знает о том каким способом (стратегией) будет
 * расчитыватся клиент, а просто вызывает метод оплаты. Все остальное стратегия
 * делает сама.
 */
class Order {
    var totalCost = 0
        set(cost) {
            field += cost
        }
    var isClosed = false
        private set

    fun processOrder(strategy: PayStrategy) {
        strategy.collectPaymentDetails()
        // Здесь мы могли бы забрать и сохранить платежные данные из стратегии.
    }

    fun setClosed() {
        isClosed = true
    }
}