package facade.some_complex_media_library

class VideoFile(name: String) {
    val codecType: String = name.substring(name.indexOf(".") + 1)
}