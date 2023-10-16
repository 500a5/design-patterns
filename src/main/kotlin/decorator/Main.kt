package decorator

import decorator.decorators.*


fun main() {
    val salaryRecords = "Name,Salary\n" +
            "John Smith,100000\n" +
            "Steven Jobs,912000"
    val fileName =
        "C:\\Users\\500a5\\IntellijIdeaProjects\\design-patterns\\src\\main\\kotlin\\decorator\\out\\OutputDemo.txt"
    val encoded: DataSourceDecorator = CompressionDecorator(
        EncryptionDecorator(
            FileDataSource(fileName)
        )
    )
    encoded.writeData(salaryRecords)
    val plain: DataSource = FileDataSource(fileName)
    println("- Input ----------------")
    println(salaryRecords)
    println("- Encoded --------------")
    println(plain.readData())
    println("- Decoded --------------")
    println(encoded.readData())
}

/**
 * Декоратор — это структурный паттерн проектирования,
 * который позволяет динамически добавлять объектам новую функциональность, оборачивая их в полезные «обёртки».
 * Декоратор позволяет оборачивать объекты бесчисленное количество раз благодаря тому, что и обёртки,
 * и реальные оборачиваемые объекты имеют общий интерфейс.
 */