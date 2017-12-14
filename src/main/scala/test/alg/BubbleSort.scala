package test.alg

import scala.util.Random

object BubbleSort extends App {
    val arr = (1 to 100).map(i => Random.nextInt().abs % 100).toArray
    sort(arr)
    println(arr.toList)

    def sort(arr: Array[Int]) {
        val size = arr.size
        var tail = size - 1 //需要比较的最后一个元素， 开始时是数组最后一个数字
        while (tail > 0) {
            for (i <- 0 until tail) { //将 arr(0) .. arr(tail) 的最大值移动到末尾
                if (arr(i) > arr(i + 1)) {
                    swap(arr, i, i + 1)
                }
            }
            tail -= 1 //此轮比较的最大值已经处于arr(tail)处， 下一轮比较时，只需比较到arr(tail-1), 所以此次tail要减1
        }
    }

    private def swap(arr: Array[Int], i: Int, j: Int) {
        val tmp = arr(i)
        arr(i) = arr(j)
        arr(j) = tmp
    }
}