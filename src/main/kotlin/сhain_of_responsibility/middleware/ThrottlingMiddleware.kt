package сhain_of_responsibility.middleware

/**
 * Конкретный элемент цепи обрабатывает запрос по-своему.
 */
class ThrottlingMiddleware(private val requestPerMinute: Int) : Middleware() {
    private var request = 0
    private var currentTime: Long

    init {
        currentTime = System.currentTimeMillis()
    }

    /**
     * Обратите внимание, вызов checkNext() можно вставить как в начале этого
     * метода, так и в середине или в конце.
     *
     * Это даёт еще один уровень гибкости по сравнению с проверками в цикле.
     * Например, элемент цепи может пропустить все остальные проверки вперёд и
     * запустить свою проверку в конце.
     */
    override fun check(email: String?, password: String?): Boolean {
        if (System.currentTimeMillis() > currentTime + 60000) {
            request = 0
            currentTime = System.currentTimeMillis()
        }
        request++
        if (request > requestPerMinute) {
            println("Request limit exceeded!")
            Thread.currentThread().stop()
        }
        return checkNext(email, password)
    }
}