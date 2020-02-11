object Etl {

  def transform(input: Map[Int, Seq[String]]): Map[String, Int] = {
    transformWithForComprehension(input)
  }
  
  def transformWithForComprehension(input: Map[Int, Seq[String]]): Map[String, Int] = {
    for {
      (digit, letters) <- input
      letterWithUpperCase <- letters
      letter =  letterWithUpperCase.toLowerCase
    } yield letter -> digit
  }

  def transformWithFlatMap(input: Map[Int, Seq[String]]): Map[String, Int] = {
    input
      .keys
      .flatMap(key => input(key).map(x => (x.toLowerCase(),key)))
      .toMap
  }
}