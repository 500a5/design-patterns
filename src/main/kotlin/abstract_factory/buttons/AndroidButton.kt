package abstract_factory.buttons

class AndroidButton:Button {
    override fun paint() {
        println("Создали android кнопку ")
    }
}