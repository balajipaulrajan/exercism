object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
      factors.flatMap(x => 0 until limit by x)
             .reduceOption(_ + _)
             .getOrElse(0)
  }
}

