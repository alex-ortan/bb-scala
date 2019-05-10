object Pr {
  def primes:Stream[Int] = {
    def sieve(s: Stream[Int]): Stream[Int] =
      s.head #:: sieve(s.filter(x => x % s.head != 0))
    1 #:: sieve(Stream.from(2))
  }
  def main(args: Array[String]): Unit = {
    primes take 10 foreach println
  }
}
