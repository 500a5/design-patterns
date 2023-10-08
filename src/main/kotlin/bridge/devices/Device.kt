package bridge.devices

interface Device {

    fun isEnabled(): Boolean
    fun enable()
    fun disable()
    fun getVolume(): Int
    fun setVolume(volume: Int)
    fun getChannel(): Int
    fun setChannel(channel: Int)
    fun printStatus()
}