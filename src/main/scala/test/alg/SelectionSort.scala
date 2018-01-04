package test.alg

import scala.util.Random

/**
  * 原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
  * 比如 a[0] .. a[i-1]是排好序的 a[i], a[i+1] .. a[n]是未排好序的，选择a[i], a[i+1] .. a[n]中最小的元素
  * 与a[i]交换
  *
  *
  **/
object SelectionSort extends App {

      test()

      def sort(arr: Array[Int]) = {

            for (i <- 0 until arr.length) {
                  //每次从arr中未排序后的数据中找出最小的元素，放到排好序的数组后面
                  swap(arr, findMinIndex(arr, i), i)
            }
      }

      def findMinIndex(arr: Array[Int], fromIndex: Int) = {
            var minIndex = fromIndex
            for (i <- fromIndex until arr.length) {
                  minIndex = if (arr(i) < arr(minIndex)) i else minIndex
            }
            minIndex
      }

      private def swap(arr: Array[Int], i: Int, j: Int) {
            val tmp = arr(i)
            arr(i) = arr(j)
            arr(j) = tmp
      }

      def test(): Unit = {
            var arr = (1 to 100).map(i => Random.nextInt().abs % 100).toArray
            sort(arr)
            println(arr.toList)
      }
}
