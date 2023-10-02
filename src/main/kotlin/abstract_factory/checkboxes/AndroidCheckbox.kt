package abstract_factory.checkboxes

class AndroidCheckbox:Checkbox {
    override fun paint() {
        println("создали android checkbox")
    }
}