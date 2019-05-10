package classstuff

class Parent /*private */ (n: String) {
  def this(n1: String, n2: String) {
    this(s"$n1  $n2")
  }

  println("I'm in the constructor")
  /*private */ var name: String = n
}

object UseIt {
  def main(args: Array[String]): Unit = {
    val p = new Parent("Albert")
    println(s"parent.name is ${p.name}")
    println(s"another name is ${new Parent("Fred", "Jones").name}")
//    val an = Another.apply(99, "Fred")
    val an = Another(99, "Fred")
    println(an)
  }
}

object Another {
  def apply(n: Int, s: String): Another = {
    println("in factory for Another")
    new Another(n, s)
  }
}

class Another protected (val number: Int, val name: String) {
  override def toString: String = s"Another: number = $number, name = $name"

  final override def equals(o: Any): Boolean = o match {
    case an: Another if an.number == this.number && an.name == this.name => true
    case _ => false
  }

  def apply(i: Int): String = s"You accessed subscript ${i}"
}

class SubAnother(number:Int, name:String, val more:String) extends Another(number, name)

//class Another(n: Int, s: String) {
//  val number = n
//  val name = s
//}

case class ANewClass(name: String, number: Int) extends Named {
  val findName = "Albert"
  def showThyself: String = s"I'm ANew ${this.toString}"
}

trait Named {
  def findName : String
  def doStuff: String = "I did some stuff"
}

object UseANew {
  def main(args: Array[String]): Unit = {
    val aNew = ANewClass("Albert", 1234)
    aNew.doStuff
    val anotherNew = ANewClass("Albert", 1234)
    println(s"aNew is ${aNew}")
    println(s"aNew == anotherNew? ${aNew == anotherNew}")
    println(s"showing: ${aNew.showThyself}")

    aNew match {
      case ANewClass(n, i) => println(s"Name is ${n} number is ${i}")
    }

    println(s"accessing element 3 ${Another(99, "Fred")(3)}")

    val names2 = Array("Fred", "Jim", "Sheila")
    println(s"names(0) is ${names2(0)}")
    names2(0) = "Frankie"
    names2.update(0, "Franky")
    println(s"names(0) is ${names2(0)}")

    val sub : Another = new SubAnother(8, "X", "Y")
    println(s"sub is ${sub}")
  }
}

class Adder {
  private var myVal = 0
  def day_= (v : Int) = myVal = v
  def day: Int = myVal
}

object TryAdder {
  def main(args: Array[String]): Unit = {
    var a = new Adder
    a.day = 3
    println(s"day is ${a.day}")
  }
}