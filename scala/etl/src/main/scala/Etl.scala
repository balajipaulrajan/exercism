object Etl {

  def transform(input: Map[Int, Seq[String]]): Map[String, Int] = {
    transformWithFlatMap(input)
  }
  
  def transformWithForComprehension(input: Map[Int, Seq[String]]): Map[String, Int] = {
    for {
      (digit, letters) <- input
      letter <- letters
    } yield (letter.toLowerCase, digit)
  }

  def transformWithFlatMap(input: Map[Int, Seq[String]]): Map[String, Int] = {
    input
      .flatMap { 
        case (digit, letters) => letters.map(_.toLowerCase() -> digit)
      }
  }
}