package memento.shapes

import java.awt.Color
import java.awt.Graphics


class CompoundShape(vararg components: Shape) : BaseShape(0, 0, Color.BLACK) {
    private var children: MutableList<Shape> = ArrayList()

    init {
        add(*components)
    }

 /*   fun add(component: Shape) {
        children.add(component)
    }*/

    fun add(vararg components: Shape) {
        children.addAll(components)
    }

    fun remove(child: Shape) {
        children.remove(child)
    }

    fun remove(vararg components: Shape) {
        children.removeAll(components)
    }

    fun clear() {
        children.clear()
    }

    override var x: Int
        get() {
            if (children.size == 0) {
                return 0
            }
            var x = children[0].x
            for (child in children) {
                if (child.x < x) {
                    x = child.x
                }
            }
            return x
        }
        set(x) {
            super.x = x
        }

    override var y: Int
        get() {
            if (children.size == 0) {
                return 0
            }
            var y = children[0].y
            for (child in children) {
                if (child.y < y) {
                    y = child.y
                }
            }
            return y
        }
        set(y) {
            super.y = y
        }

    override val width: Int
        get() {
            var maxWidth = 0
            val x = x
            for (child in children) {
                val childsRelativeX = child.x - x
                val childWidth = childsRelativeX + child.width
                if (childWidth > maxWidth) {
                    maxWidth = childWidth
                }
            }
            return maxWidth
        }

    override val height: Int
        get() {
            var maxHeight = 0
            val y = y
            for (child in children) {
                val childsRelativeY = child.y - y
                val childHeight = childsRelativeY + child.height
                if (childHeight > maxHeight) {
                    maxHeight = childHeight
                }
            }
            return maxHeight
        }

    override fun move(x: Int, y: Int) {
        for (child in children) {
            child.move(x, y)
        }
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                return true
            }
        }
        return false
    }

    override fun unSelect() {
        super.unSelect()
        for (child in children) {
            child.unSelect()
        }
    }

    fun selectChildAt(x: Int, y: Int): Boolean {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                child.select()
                return true
            }
        }
        return false
    }

    override fun paint(graphics: Graphics) {
        if (isSelected) {
            enableSelectionStyle(graphics)
            graphics.drawRect(x - 1, y - 1, width + 1, height + 1)
            disableSelectionStyle(graphics)
        }
        for (child in children) {
            child.paint(graphics)
        }
    }


    fun getChildAt(x: Int, y: Int): Shape? {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                return child
            }
        }
        return null
    }


    fun getSelected(): List<Shape>? {
        val selected: MutableList<Shape> = ArrayList()
        for (child in children) {
            if (child.isSelected) {
                selected.add(child)
            }
        }
        return selected
    }

    override fun drag() {
        for (child in children) {
            child.drag()
        }
    }

    override fun moveTo(x: Int, y: Int) {
        for (child in children) {
            child.moveTo(x, y)
        }
    }

    override fun moveBy(x: Int, y: Int) {
        for (child in children) {
            child.moveBy(x, y)
        }
    }


    override fun setColor(color: Color?) {
        for (child in children) {
            child.setColor(color)
        }
    }
}