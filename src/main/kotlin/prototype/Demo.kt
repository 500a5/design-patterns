package prototype

import prototype.shape.Circle
import prototype.shape.Rectangle
import prototype.shape.Shape


fun main() {
    val shapes: MutableList<Shape> = ArrayList()
    val shapesCopy: MutableList<Shape> = ArrayList()
    val circle = Circle()
    circle.x = 10
    circle.y = 20
    circle.radius = 15
    circle.color = "red"
    shapes.add(circle)
    val anotherCircle = circle.clone() as Circle
    shapes.add(anotherCircle)
    val rectangle = Rectangle()
    rectangle.width = 10
    rectangle.height = 20
    rectangle.color = "blue"
    shapes.add(rectangle)
    cloneAndCompare(shapes, shapesCopy)
}

private fun cloneAndCompare(shapes: List<Shape>, shapesCopy: MutableList<Shape>) {
    for (shape in shapes) {
        shapesCopy.add(shape.clone())
    }
    for (i in shapes.indices) {
        if (shapes[i] !== shapesCopy[i]) {
            println("$i: Это разные объекты ")
            if (shapes[i].equals(shapesCopy[i])) {
                println("$i: Они идентичны, один в один прям но объекты разные) ")
            } else {
                println("$i: Они не идентичны ")
            }
        } else {
            println("$i: Это одинаковые объекты ")
        }
    }
}