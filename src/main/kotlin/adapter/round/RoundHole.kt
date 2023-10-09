package adapter.round

/**
 * КруглоеОтверстие совместимо с КруглымиКолышками.
 */
class RoundHole(private val radius: Double) {

    fun fits(peg: RoundPeg): Boolean {
        return radius >= peg.radius
    }
}