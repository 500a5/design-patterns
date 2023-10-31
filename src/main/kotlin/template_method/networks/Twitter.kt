package template_method.networks

/**
 * Класс социальной сети.
 */
class Twitter(userName: String?, password: String?) : Network() {
    init {
        this.userName = userName
        this.password = password
    }

    override fun logIn(userName: String?, password: String?): Boolean {
        println("\nChecking user's parameters")
        println("Name: " + this.userName)
        print("Password: ")
        for (i in 0 until this.password!!.length) {
            print("*")
        }
        simulateNetworkLatency()
        println("\n\nLogIn success on Twitter")
        return true
    }

    override fun sendData(data: ByteArray?): Boolean {
        val messagePosted = true
        return if (messagePosted) {
            println("Message: '" + String(data!!) + "' was posted on Twitter")
            true
        } else {
            false
        }
    }

    override fun logOut() {
        println("User: '$userName' was logged out from Twitter")
    }

    private fun simulateNetworkLatency() {
        try {
            var i = 0
            println()
            while (i < 10) {
                print(".")
                Thread.sleep(500)
                i++
            }
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }
}