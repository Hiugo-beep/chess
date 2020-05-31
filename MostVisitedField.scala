package Interface

object MostVisitedField {
  def checkMostVisitedField(str: String, args: Array[Int]) : Unit = {
    var massBuf = new Array[String](str.length)
    var i = 0
    str.toCharArray
    while(i < str.length){
      var temp :String=  "" + str(i) + str(1+i)
      massBuf(i) = temp
      i+=2
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
      println("NEW LIST " + newList)
      size = newList.size
      if(count < size) {
        count = size
        realStr = tempStr
      }
      i+=2
    }
    realStr.toCharArray;
    val redCellX:Int = realStr(0) - 0x30
    val redCellY:Int = realStr(1) - 0x30
    args(0) = redCellX
    args(1) = redCellY
    println("COUNT " +  count + "RealStr" + realStr)

  }
}
