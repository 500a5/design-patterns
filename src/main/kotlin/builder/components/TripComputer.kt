package builder.components

import builder.cars.Car


/**
 * Одна из фишек автомобиля.
 */
class TripComputer {
     var car: Car? = null

    fun showFuelLevel() {
        println("Fuel level: " + car?.fuel)
    }

    fun showStatus() {
        if (car?.engine?.started == true) {
            println("Автомобиль заведен")
        } else {
            println("Автомобиль не заведен")
        }
    }
}