package hello

object Hello {
  def +++ (s : String) = s"The message is ${s}"
  def fruit (theFruit : String) = s"The fruit is $theFruit or ${theFruit.toUpperCase}"

  def main(args : Array[String]) : Unit = {
    println("Hello World!")
    var s : String = "Hello"
    val t = "Hello"
    val i : Int = 99
    val sb = new StringBuilder("Hello")
    sb.append(" World")
    println(sb)
//    sb = new StringBuilder("goodbye")
    println(i.+(2))
    println(i + 2)
    println(Hello.getClass.getName)
    println(Hello.+++("secret"))
    println(Hello +++ "secret")
    println(Hello fruit "banana")

    val threshold = math.random()
    println {
      "I'm feeling" +
        (if (threshold > 0.5) " happy" else " sad")
    }
    var idx = 0
    while (idx < 10) {
      val immutable = idx
//      immutable += 1
      println(idx)
      idx += 1
    }

    val names = List("Fred", "Jim", "Shiela")
    println(s"the first name is ${names(0)}")
    for (s <- names) println(s)

    val sw : Any = "Fred"
    val msg = sw match {
      case 99 | 100 | 101 => "It's ninety nine ish..."
      case x => {
        println("in the default thingy")
        s"Something else, specifically ${x}"
      }
    }
    println(msg)
  }
}
