import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import akka.actor.typed.{ActorSystem, Behavior}


object Main {
 def apply(): Behavior[String] =
   Behaviors.setup(ctx => new Main(ctx))
}

class Main(ctx: ActorContext[String]) extends AbstractBehavior[String](ctx) {
  override def onMessage(msg: String): Behavior[String] = {
    msg match {
      case "hello" =>
        println(s"${context.self}: Get hello")
        Behaviors.same
      case "other" =>
        println(s"${context.self}: get other")
        Behaviors.same
      case "create" =>
        val addr = context.spawn(Behaviors.empty[String], "SomeAktor")
        println(s"Create aktor complete ${addr}")
        println(s"${context.self}: get other")
        Behaviors.same
      case _ =>
        println(s"${context.self}: get unknown msg")
        Behaviors.same
    }
  }
}

object AppStart extends App {
  val system = ActorSystem(Main(), "SomeApp")

  system ! "start"
  system ! "create"
  system ! "search"
}