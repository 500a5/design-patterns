package abstract_factory.checkboxes

class IosCheckbox : Checkbox {
    override fun paint() {
        println("создали ios чекбокс")
    }
}