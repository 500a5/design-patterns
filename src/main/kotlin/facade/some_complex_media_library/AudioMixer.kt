package facade.some_complex_media_library

import java.io.File


class AudioMixer {
    fun fix(result: VideoFile?): File {
        println("AudioMixer: fixing audio...")
        return File("tmp")
    }
}