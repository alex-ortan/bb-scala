package implicitstuff

object StringIntUtils {
  implicit def bananaSplit(i: Int): String = "Value is " + i
  implicit class Message(val m: String) {
    def shoutIt: Unit = println(m.toUpperCase)
  }
}

object UseImplicits {
  def foreach[T](s: List[T])(op: T => Unit): Unit = s match {
    case Nil =>
    case head :: tail => op(head) ; foreach(tail)(op)
  }

  def showMe[T](s: List[T])(implicit op: T => Unit): Unit = s match {
    case Nil =>
    case head :: tail => op(head) ; showMe(tail)/*(op)*/
//    case List() =>
//    case List(x) =>
//    case List(x, y) =>
  }

  def main(args: Array[String]): Unit = {
    val i: Int = 99

    import StringIntUtils.bananaSplit
    val s: String = i

    println(s"String is ${s}")

    showMe(List("Fred", "Jim", "Sheila"))(s => println(s))

    {
      println("-----------------------")
      implicit val printIt: String => Unit =
        s => println(s"This was printed by the implicit param ${s}")
      showMe(List("Fred", "Jim", "Sheila"))
      showMe(List("Fred", "Jim", "Sheila"))(s => println(s"I shall not be beaten ${s}"))
    }
    {
      println("-----------------------")
      implicit val otherPrint: String => Unit =
        s => println(s"otherPrint ${s}")
      showMe(List("Fred", "Jim", "Sheila"))

      implicit val numPrint: Int => Unit = n => println(s"The number is ${n}")
      showMe(List(1, 2, 3))
    }
//    implicit val strToMsg : String => Message = s => new Message(s)

    import StringIntUtils.Message
    "hello".shoutIt

    foreach(List("Fred", "Jim", "Sheila"))(x => println(x))
  }
}
