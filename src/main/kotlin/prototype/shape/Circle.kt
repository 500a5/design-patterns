package prototype.shape

class Circle : Shape {
    var radius = 0

    constructor() {}
    constructor(target: Circle?) : super(target) {
        if (target != null) {
            radius = target.radius
        }
    }

    override fun clone(): Shape {
        return Circle(this)
    }

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Circle || !super.equals(object2)) return false
        return object2.radius == radius
    }
}