package Interface

import akka.actor._
import akka.util._
object ActorServer {

  var buf:ActorRef = null
  var  customer:Thread = null
  var thread:Thread = null
  var sleepy:Sleeper = null
  var customSl:Sleeper = null

  def stopThreadServer(): Unit ={
    buf ! "StopServer"
  }
  def runThreadServer(): Unit ={
    buf ! "RunServer"
  }
  def stopThreadClient(): Unit ={
    buf ! "StopClient"
  }
  def runThreadClient(): Unit ={
    buf ! "RunClient"
  }
  def main( thServ:Thread , thCl:Thread, slServ:Sleeper, slCl:Sleeper): Unit = {
    val system = ActorSystem("system")
    val addressActor = system.actorOf(ServerActor.props( "ServerActor"))
    buf = addressActor
     customer = thCl
    thread = thServ
    sleepy = slServ
    customSl = slCl
  }


  class ServerActor(val name:String) extends Actor {
    override def receive: Receive = {
      case "StopServer" => thread.interrupt()
      case "RunServer" => sleepy.interrupt()
      case "StopClient" => customer.interrupt()
      case "RunClient" => customSl.interrupt()
    }
  }

  object ServerActor {
    def props(name:String ) : Props = Props(new ServerActor( "ServerActor"))
  }

}



