package test.adt

private case class Node[Data](data: Data, var next: Node[Data])
class LinkList[Data] {

    private var head: Node[Data] = null;
    private var current: Node[Data] = null;
    private var _size = 0

    def size = _size
    def isEmpty = size == 0

    def add(data: Data) {
        if (isEmpty) {
            head = Node(data, null)
            current = head
        } else {
            var node = Node(data, null)
            current.next = node
            current = node
        }
        _size += 1
    }

    /**
     * @param data 删除链表中与data相等的第一个元素
     * @return
     */
    def remove(data: Data): Boolean = {
        if (isEmpty) {
            return false
        }
        var c = head
        var prev: Node[Data] = null
        while (true) {
            if (c == null) {
                return false
            }
            if (c.data == data && prev == null) { //第一个元素匹配
                head = c.next
                _size -= 1
                return true
            }
            if (c.data == data && prev != null) {
                prev.next = c.next // 将c删除， 前驱节点的next 指向c的next
                _size -= 1
                return true
            }
            prev = c
            c = c.next
        }
        return false
    }

    def printAll = {
        var c = head
        while (c != null) {
            print(c.data + ",")
            c = c.next
        }
        println()

    }

}

object LinkList extends App {
    def apply[Data] = new LinkList[Data]()
    val list =  LinkList[String]
    
    println(list.size)
    list.add("1")
    println(list.size == 1)
    list.add("2")
    println(list.size == 2)
    list.add("3")
    list.add("4")
    println(list.size == 4)

    list.printAll
    list.remove("3")
    list.remove("1")
    list.printAll
    println(list.size == 2)
    list.remove("4")
    list.printAll
    println(list.size == 1)

    list.remove("2")
    list.printAll
    println(list.size == 0)
    
    println("list is empty:" + list.isEmpty)
}












