package factory_method.buttons

class IosButton : Button {
    override fun render() {
        println("Создали ios кнопку")
        onClick()
    }

    override fun onClick() {
        println("Нажали ios кнопку")
    }
}