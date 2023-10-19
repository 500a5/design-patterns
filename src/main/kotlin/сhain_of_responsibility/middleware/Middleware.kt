package сhain_of_responsibility.middleware

/**
 * Базовый класс цепочки.
 */
abstract class Middleware {
    private var next: Middleware? = null

    /**
     * Подклассы реализуют в этом методе конкретные проверки.
     */
    abstract fun check(email: String?, password: String?): Boolean

    /**
     * Запускает проверку в следующем объекте или завершает проверку, если мы в
     * последнем элементе цепи.
     */
    protected fun checkNext(email: String?, password: String?): Boolean {
        return if (next == null) {
            true
        } else next!!.check(email, password)
    }

    companion object {
        /**
         * Помогает строить цепь из объектов-проверок.
         */
        fun link(first: Middleware, vararg chain: Middleware): Middleware {
            var head = first
            for (nextInChain in chain) {
                head.next = nextInChain
                head = nextInChain
            }
            return first
        }
    }
}