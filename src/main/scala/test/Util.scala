package test

import scala.util.Random

object Util {

      def swap(arr: Array[Int], i: Int, j: Int) {
            val tmp = arr(i)
            arr(i) = arr(j)
            arr(j) = tmp
      }

      def createRandomArr = (1 to 100).map(i => Random.nextInt().abs % 100).toArray
}
