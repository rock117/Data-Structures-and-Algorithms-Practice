package test.alg
import scala.util.Random

/**
  * 快速排序：时间复杂度　Ｏ（ｎｌｇｎ）
 * 原理：以某一个数为基准，小于这个数的排到左边，大于的排右边
 */
object QuickSort extends App{

    test()
    
    def sort(arr: Array[Int]):Array[Int] = {
        if(arr.isEmpty){
            return arr
        }
        val pivot = arr(0) //基准数
        val arrTuple = split(pivot, arr.tail) //将数组分割为2组，左边为小于等于pivot, 右边为大于pivot的


        val left = sort(arrTuple._1)//递归调用
        val right = sort(arrTuple._2)

        return (left :+ pivot) ++ right //左边的，pivot, 右边的 合并成最终的数组
    }

    private def split(pivot:Int, arr:Array[Int]): (Array[Int], Array[Int]) = {
        if(arr.isEmpty){
            return (Array.empty[Int], Array.empty[Int])
        }
        var first = Array[Int]()
        var second = Array[Int]()
        for(i <- 0 until arr.size){
            if(arr(i) <= pivot){
                first = first :+ arr(i)
            }
            else{
                second = second :+ arr(i)
            }
        }
        (first, second)
    }

    def test(): Unit ={
        var arr = (1 to 100).map(i => Random.nextInt().abs % 100).toArray
        arr = sort(arr)
        println(arr.toList)
    }
}