package facade

import facade.facade.VideoConversionFacade
fun main() {
    val converter = VideoConversionFacade()
    val mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4")
    // ...
}
/**
 * Фасад — это структурный паттерн проектирования, который предоставляет простой интерфейс к сложной системе классов,
 * библиотеке или фреймворку.
 * Кроме того, что Фасад позволяет снизить общую сложность программы, он также помогает вынести код,
 * зависимый от внешней системы в единственное место.
 *
 * Фасад — это простой интерфейс для работы со сложной подсистемой, содержащей множество классов. Фасад может иметь урезанный интерфейс,
 * не имеющий 100% функциональности, которой можно достичь, используя сложную подсистему напрямую. Но он предоставляет именно те фичи,
 * которые нужны клиенту, и скрывает все остальные.
 * Фасад полезен, если вы используете какую-то сложную библиотеку со множеством подвижных частей, но вам нужна только часть её возможностей.
 *
 * К примеру, программа, заливающая видео котиков в социальные сети,
 * может использовать профессиональную библиотеку сжатия видео. Но все,
 * что нужно клиентскому коду этой программы — простой метод encode(filename, format). Создав класс с таким методом,
 * вы реализуете свой первый фасад.
 *
 * Признаки применения паттерна: Фасад угадывается в классе, который имеет простой интерфейс,
 * но делегирует основную часть работы другим классам. Чаще всего, фасады сами следят за жизненным циклом объектов сложной системы.
 *
 * В этом примере Фасад упрощает работу клиента со сложной библиотекой видеоконвертации.
 *
 * Фасад предоставляет пользователю лишь один простой метод, скрывая за собой целую систему с видеокодеками,
 * аудиомикшерами и другими не менее сложными объектами.
 */
