package test.alg

import test.Util
import test.alg.SelectionSort.{findMinIndex, swap}

object InsertSort extends App {

      def sort(arr: Array[Int]): Unit = {
            for (i <- 0 until arr.length) {
                  //每次从arr中未排序后的数据中找出最小的元素，放到排好序的数组后面
                  insertToSortedArr(arr, i, arr(i))
            }
      }

      private def insertToSortedArr(arr:Array[Int], tailIndex:Int, elementIndex:Int): Unit ={
            for(i <- 0 until tailIndex){
      //TODO
            }
      }
}
