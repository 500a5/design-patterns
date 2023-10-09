package adapter.round


/**
 * КруглыеКолышки совместимы с КруглымиОтверстиями.
 */
open class RoundPeg() {
    open var radius = 0.0
    constructor(radius: Double) : this() {
        this.radius = radius
    }
}