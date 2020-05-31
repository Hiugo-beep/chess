package Interface

object mostMovement {
  def checkMostFrequentMovement(str: String, args: Array[Int]) : Unit = {

    var massBuf = new Array[String](str.length)

    var i = 0

    str.toCharArray

    while(i < str.length){
      var temp :String=  "" + str(i) + str(1+i) + str(2+i) + str(3+i)
      massBuf(i) = temp
      i+=4
    }

    var myList:List[String] = massBuf.toList
    var realStr = ""
    var count:Int = 0
    var size:Int = 0
    i = 0
    while(i < str.length) {
      var tempStr = massBuf(i)
      var myTempList:List[String]  = List(tempStr,tempStr,tempStr,tempStr,tempStr)

      var cmpList = List(myTempList,myList)
      var newList = cmpList.reduceLeft(_.intersect(_))
      println("DDDDD " + newList)
      size = newList.size
      //println( tempStr + " COUNT " + size)
      if(count < size) {
        count = size
        realStr = tempStr
      }
      i+=4
    }
    realStr.toCharArray;
    val oX:Int = realStr(0) - 0x30
    val oY:Int = realStr(1) - 0x30
    val nX:Int = realStr(2) - 0x30
    val nY:Int = realStr(3) - 0x30
    args(0) = oX
    args(1) = oY
    args(2) = nX
    args(3) = nY

    println("COUNT " +  count + "RealStr" + realStr)

  }
}
