package Interface

object quickSort {
  def sorting(args: Array[Int], low: Int, high: Int): Unit = {
    if (low >= high) return
    else {
      var middle = low + (high - low) / 2
      var opora = args(middle)
      var i = low
      var j = high
      while (i <= j) {
        while (args(i) > opora) {
          i = i + 1
        }
        while (args(j) < opora) {
          j = j - 1
        }
        if (i <= j) { //меняем местами
          val temp = args(i)
          args(i) = args(j)
          args(j) = temp
          i = i + 1
          j = j - 1
        }

      }
      if (low < j)
        sorting(args, low, j)
      if (high > i)
        sorting(args, i, high)
    }

  }
}
