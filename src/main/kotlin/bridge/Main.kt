package bridge

import bridge.devices.Device
import bridge.devices.Radio
import bridge.devices.Tv
import bridge.remotes.AdvancedRemote
import bridge.remotes.BasicRemote


fun main() {
    testDevice(Tv())
    testDevice(Radio())
}

fun testDevice(device: Device) {
    println("Tests with basic remote.")
    val basicRemote = BasicRemote(device)
    basicRemote.power()
    device.printStatus()
    println("Tests with advanced remote.")
    val advancedRemote = AdvancedRemote(device)
    advancedRemote.power()
    advancedRemote.mute()
    device.printStatus()
}
/**
Мост — это структурный паттерн, который разделяет бизнес-логику или большой класс на несколько отдельных иерархий,
которые потом можно развивать отдельно друг от друга.
Одна из этих иерархий (абстракция) получит ссылку на объекты другой иерархии (реализация) и будет делегировать им основную работу.
Благодаря тому, что все реализации будут следовать общему интерфейсу, их можно будет взаимозаменять внутри абстракции.

 */