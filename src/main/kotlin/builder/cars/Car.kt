package builder.cars

import builder.components.Engine
import builder.components.GPSNavigator
import builder.components.Transmission
import builder.components.TripComputer

/**
 * Автомобиль — это класс продукта.
 */
class Car(
    val carType: CarType?,
    val seats: Int?,
    val engine: Engine?,
    val transmission: Transmission?,
    val tripComputer: TripComputer?,
    val gpsNavigator: GPSNavigator?
) {

    var fuel = 0.0
        private set

    init {
        this.tripComputer?.let { this.tripComputer.car = this }
    }

}