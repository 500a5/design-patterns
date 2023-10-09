package adapter

import adapter.adapters.SquarePegAdapter
import adapter.round.RoundHole
import adapter.round.RoundPeg
import adapter.square.SquarePeg

fun main() {
    // Круглое к круглому — всё работает.
    val hole = RoundHole(5.0)
    val rpeg = RoundPeg(5.0)
    if (hole.fits(rpeg)) {
        println("Круглый штифт r5 подходит к круглому отверстию r5.")
    }
    val smallSqPeg = SquarePeg(2.0)
    val largeSqPeg = SquarePeg(20.0)
    // hole.fits(smallSqPeg); // Не скомпилируется.

    // Адаптер решит проблему.
    val smallSqPegAdapter = SquarePegAdapter(smallSqPeg)
    val largeSqPegAdapter = SquarePegAdapter(largeSqPeg)
    if (hole.fits(smallSqPegAdapter)) {
        println("Квадратный штифт w2 подходит к круглому отверстию r5.")
    }
    if (!hole.fits(largeSqPegAdapter)) {
        println("Квадратный штифт w20 не входит в круглое отверстие r5.")
    }
}