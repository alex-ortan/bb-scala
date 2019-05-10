package functs

object UseLazy {
  def lazyUse(v: => String): Unit = {
    /*lazy */val n = v;

    if (math.random > 0.5) {
      println(n)
    }
  }

  def getValue: String = {
    println("Evaluating string...")
    "Magical String"
  }

  def main(args: Array[String]): Unit = {
    lazyUse(getValue)
  }
}
