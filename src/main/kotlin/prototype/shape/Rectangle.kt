package prototype.shape

class Rectangle : Shape {
    var width = 0
    var height = 0

    constructor()
    constructor(target: Rectangle?) : super(target) {
        if (target != null) {
            width = target.width
            height = target.height
        }
    }

    override fun clone(): Shape {
        return Rectangle(this)
    }

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Rectangle || !super.equals(object2)) return false
        val shape2 = object2
        return shape2.width == width && shape2.height == height
    }
}