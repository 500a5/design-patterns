package simple_factory

class UserFactory {
    fun create(type: String): Any {
        return when (type) {
            "user" -> User()
            "customer" -> Customer()
            "admin" -> Admin()
            else -> throw Exception("errrror")
        }
    }
}