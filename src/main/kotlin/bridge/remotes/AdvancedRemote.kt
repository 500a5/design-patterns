package bridge.remotes

import bridge.devices.Device


class AdvancedRemote(device: Device) : BasicRemote() {
    init {
        super.device = device
    }

    fun mute() {
        println("Remote: mute")
        device.setVolume(0)
    }
}