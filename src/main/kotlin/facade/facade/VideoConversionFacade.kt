package facade.facade


import facade.some_complex_media_library.*
import java.io.File


// Фасад библиотеки работы с видео
class VideoConversionFacade {
    fun convertVideo(fileName: String, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName)
        val sourceCodec = CodecFactory().extract(file)
        val destinationCodec: Codec = if (format == "mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        val buffer = BitrateReader().read(file, sourceCodec)
        val intermediateResult = BitrateReader().convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}