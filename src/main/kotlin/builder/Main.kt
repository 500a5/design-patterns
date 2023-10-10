package builder

import builder.builders.CarBuilder
import builder.builders.CarManualBuilder
import builder.cars.Manual
import builder.director.Director


fun main() {
    val director = Director()

    // Директор получает объект конкретного строителя от клиента
    // (приложения). Приложение само знает какой строитель использовать,
    // чтобы получить нужный продукт.
    val builder = CarBuilder()
    director.constructSportsCar(builder)

    // Готовый продукт возвращает строитель, так как Директор чаще всего не
    // знает и не зависит от конкретных классов строителей и продуктов.
    val car = builder.getResult()
    println("Автомобиль создан:${car.carType}")

    val manualBuilder = CarManualBuilder()
    // Директор может знать больше одного рецепта строительства.
    director.constructSportsCar(manualBuilder)
    val carManual: Manual = manualBuilder.getResult()
    println("Мануал автомобиля создан: ${carManual.print()}")
}