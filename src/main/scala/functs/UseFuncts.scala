package functs

import java.sql.SQLException

import scala.util.{Failure, Success, Try}

object UseFuncts {

//  def dayOfWeek(day: Int)(month: Int)(year: Int = 2000): Int = dayOfWeek(day, month, year)

  def dayOfWeek(day: Int, month: Int, year: Int = 2000): Int = {
    val (m, y) =  if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400) % 7
  }

  def doNTimes(n: Int)(op:/* => */Unit): Unit = n match {
    case theValue if theValue > 0 => op ; doNTimes(theValue - 1)(op)
    case _ =>
  }

  def main(args: Array[String]): Unit = {
    println(s"Day of week of Jan 1, 2000 ${dayOfWeek(1, year = 2000, month = 1)}")

    doNTimes(0) {
      println("Running this code")
    }

//    Try {
//      if (math.random > 0.5) throw new SQLException("DB broke")
//      else 1234
//    } match {
//      case Success(value) => println(s"I succeeded, value is ${value}")
//      case Failure(t) => println(s"That broke, reason is ${t.getMessage}")
//    }
  }
}

