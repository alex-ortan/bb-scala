package listystuff

import implicitstuff.StringIntUtils.Message

import scala.annotation.tailrec

object MyList {

  def filter[T](l: List[T])(op: T => Boolean): List[T] = l match {
    case Nil => Nil
    case h :: t => if (op(h)) (h :: filter(t)(op)) else (filter(t)(op))
  }
//  @tailrec
  def map[T, U](l: List[T])(op: T => U): List[U] = l match {
    case Nil => Nil
    case h :: t => op(h) :: map(t)(op)
  }
  @tailrec
  def forEach[T](l: List[T])(op: T => Unit): Unit = l match {
    case Nil =>
    case h :: tail => op(h) ; forEach(tail)(op)
  }

  def even: Stream[Int] = {
    def next(i: Int): Stream[Int] = i #:: next(i + 2)
    next(2)
  }

  def main(args: Array[String]): Unit = {
    val names = "Fred" :: "Jim" :: "Shiela" :: Nil
    println(names)
    val nowt : List[Nothing] = Nil
    val greet = Nil.::("Hello").::("Bonjour")
    val confused = 99 :: greet
    println(greet)
    println(confused)
    val conf2 = new Message("Odd") :: greet

    val more = "Albert" :: 3.14 :: (greet.tail)
    println(more)

    println("---------------------")
    forEach(greet)(println)

    println("---------------------")
    forEach(map(greet)(_.toUpperCase))(println)

    println("---------------------")
    forEach(filter(greet)(_.length > 5))(println)

    println("---------------------")
    greet map (_.toUpperCase) filter (_.length > 5) foreach println

    println("---------------------")
    names.map(_.toUpperCase).flatMap(s => s.toCharArray).foreach(println)

    println("---------------------")
    val sum = (1 to 10).map(_*2).reduce(_ + _)
    println(sum)

    println("---------------------")
    val res = (1 to 10).map(_*2).foldLeft("The numbers are: ")((s, i) => s + ", " + i)
    println(res)

    even.take(10).map(_/2).foreach(println)
  }
}
