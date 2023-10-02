package factory_method.buttons

class AndroidButton : Button {
    override fun render() {
        println("Создали android кнопку")
        onClick()
    }

    override fun onClick() {
        println("Нажали android кнопку")
    }
}