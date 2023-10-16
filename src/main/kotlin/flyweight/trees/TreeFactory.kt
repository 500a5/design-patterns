package flyweight.trees

import java.awt.Color


object TreeFactory {
    private var treeTypes: MutableMap<String, TreeType> = HashMap()
    fun getTreeType(name: String, color: Color, otherTreeData: String): TreeType {
        var result = treeTypes[name]
        if (result == null) {
            result = TreeType(name, color, otherTreeData)
            treeTypes[name] = result
        }
        return result
    }
}