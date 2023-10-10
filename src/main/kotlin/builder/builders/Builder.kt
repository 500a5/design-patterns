package builder.builders

import builder.cars.CarType
import builder.components.Engine
import builder.components.GPSNavigator
import builder.components.Transmission
import builder.components.TripComputer

interface Builder {
    fun setCarType(type: CarType)
    fun setSeats(seats: Int)
    fun setEngine(engine: Engine)
    fun setTransmission(transmission: Transmission)
    fun setTripComputer(tripComputer: TripComputer)
    fun setGPSNavigator(gpsNavigator: GPSNavigator)
}