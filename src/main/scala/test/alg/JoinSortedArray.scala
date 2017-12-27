package test.alg

/**
  * 将2个有序集合合并成1个有序集合
  */
object JoinSortedArray extends App{

      test()

      def combineSortedArray(arr1: Array[Int], arr2: Array[Int]) = {
            val minSize = Math.min(arr1.size, arr2.size)

            //记录当前插入到新数组里的两个数组的当前索引
            var index1 = 0
            var index2 = 0
            var result = Array.empty[Int]
            while (index1 < arr1.size && index2 < arr2.size) {//任一索引都没超过各自数组的容量
                  if (arr1(index1) <= arr2(index2)) {
                        result = result :+ arr1(index1)
                        index1 += 1
                  }
                  else {
                        result = result :+ arr2(index2)
                        index2 += 1
                  }
            }

            for(i <- minSize until arr1.size){
                  result = result :+ arr1(i)
            }
            for(i <- minSize until arr2.size){
                  result = result :+ arr2(i)
            }
            result
      }

      def test(): Unit ={
            val arr1 = Array(3, 7, 11, 12, 99)
            val arr2 = Array(0, 9, 10, 18)
            println(combineSortedArray(arr1, arr2).toList)

      }
}
