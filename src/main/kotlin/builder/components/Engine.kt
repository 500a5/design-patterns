package builder.components

class Engine(
    val volume: Double,
    var mileage: Double
) {

    var started = false

    fun on() {
        started = true
    }

    fun off() {
        started = false
    }

    fun go(mileage: Double) {
        if (started) {
            this.mileage += mileage
        } else {
           println("Невозможно ехать, сначала необходимо запустить двигатель!")
        }
    }

}