package prototype.shape

abstract class Shape {
    var x = 0
    var y = 0
    var color: String? = null

    constructor()
    constructor(target: Shape?) {
        if (target != null) {
            x = target.x
            y = target.y
            color = target.color
        }
    }

    abstract fun clone(): Shape

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Shape) return false
        val shape2 = object2
        return shape2.x == x && shape2.y == y && shape2.color == color
    }
}