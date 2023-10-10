package builder.cars

import builder.components.Engine
import builder.components.GPSNavigator
import builder.components.Transmission
import builder.components.TripComputer

/**
 * Руководство автомобиля — это второй продукт. Заметьте, что руководство и сам
 * автомобиль не имеют общего родительского класса. По сути, они независимы.
 */
class Manual(
    private val carType: CarType?,
    private val seats: Int?,
    private val engine: Engine?,
    private val transmission: Transmission?,
    private val tripComputer: TripComputer?,
    private val gpsNavigator: GPSNavigator?
) {
    fun print(): String {
        var info = ""
        info += "Тип машины: $carType\n"
        info += "Кол-во мест: $seats\n"
        info += "Двигатель: объем - " + engine?.volume + "; пробег - " + engine?.mileage
        info += "трансмиссия: $transmission\n"
        info += if (tripComputer != null) "Trip Computer: Functional" else "Trip Computer: N/A"
        info += if (gpsNavigator != null) "GPS Navigator: Functional" else "GPS Navigator: N/A"
        return info
    }
}