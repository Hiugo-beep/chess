package Interface

object TranslateNotation {
  def TranslateNotationInto(str: String, args: Array[String]): Unit ={

    var size:Int = str.length
    var sizeFinal:Int = size + size/2
    var strBuf:String = ""
    var count:Int = 0
    var j:Int = 0
    println("SCALA: myString " + str)
    var flag:Int = 0
    while(count<sizeFinal) {
      strBuf += str.charAt(j)
      j+=1
      count += 1
      str.charAt(j) match {
        case '0' => {strBuf += "A"}
        case '1' => {strBuf += "B"}
        case '2' => {strBuf += "C"}
        case '3' => {strBuf += "D"}
        case '4' => {strBuf += "E"}
        case '5' => { strBuf += "F"}
        case '6' => { strBuf += "G"}
        case '7' => {strBuf += "H"}
        case _ => {strBuf +=  str.charAt(j)}

      }
      count += 1
      j+=1
      if(flag == 0 ){
        strBuf += ":"
      }else {
        strBuf += ";"
      }

      if(flag == 0 ) flag = 1
      else flag = 0

        count += 1

    }

    val result:String = strBuf
    args(0)= result
  }


  def TranslateNotationFrom(str: String, args: Array[String]): Unit ={

    var size:Int = str.length
    var strBuf:String = ""
    var count:Int = 0
    var j:Int = 0


    while(j<size) {
      strBuf += str.charAt(j)
      j+=1
      var strTemp:String = "" + str.charAt(j)
      str.charAt(j)match {
        case 'A' => {strBuf += "0"}
        case 'B' => {strBuf += "1"}
        case 'C' => {strBuf += "2"}
        case 'D' => {strBuf += "3"}
        case 'E' => {strBuf += "4"}
        case 'F' => { strBuf += "5"}
        case 'G' => { strBuf += "6"}
        case 'H' => {strBuf += "7"}
        case _ => {strBuf +=  str.charAt(j)}

      }
      j += 2


    }

    val result:String = strBuf
    args(0)= result
  }
}
