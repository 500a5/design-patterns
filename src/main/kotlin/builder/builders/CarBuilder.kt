package builder.builders

import builder.cars.Car
import builder.cars.CarType
import builder.components.Engine
import builder.components.GPSNavigator
import builder.components.Transmission
import builder.components.TripComputer


/**
 * Конкретные строители реализуют шаги, объявленные в общем интерфейсе.
 */
class CarBuilder : Builder {
    private var type: CarType? = null
    private var seats : Int? = null
    private var engine: Engine? = null
    private var transmission: Transmission? = null
    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null
    override fun setCarType(type: CarType) {
        this.type = type
    }

    override fun setSeats(seats: Int) {
        this.seats = seats
    }

    override fun setEngine(engine: Engine) {
        this.engine = engine
    }

    override fun setTransmission(transmission: Transmission) {
        this.transmission = transmission
    }

    override fun setTripComputer(tripComputer: TripComputer) {
        this.tripComputer = tripComputer
    }

    override fun setGPSNavigator(gpsNavigator: GPSNavigator) {
        this.gpsNavigator = gpsNavigator
    }

    fun getResult(): Car {
        return Car(type, seats, engine, transmission, tripComputer, gpsNavigator)
    }
}