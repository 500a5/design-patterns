package decorator.decorators

open class DataSourceDecorator internal constructor(private val wrappee: DataSource) : DataSource {
    override fun writeData(data: String?) {
        wrappee.writeData(data)
    }

    override fun readData(): String? {
        return wrappee.readData()
    }
}