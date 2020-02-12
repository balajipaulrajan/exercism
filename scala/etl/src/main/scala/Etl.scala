object Etl {

  def transform(input: Map[Int, Seq[String]]): Map[String, Int] = {
    transformWithFlatMap(input)
  }
  
  def transformWithForComprehension(input: Map[Int, Seq[String]]): Map[String, Int] = {
    for {
      (digit, letters) <- input
      letterWithUpperCase <- letters
      letter =  letterWithUpperCase.toLowerCase
    } yield (letter, digit)
  }

  def transformWithFlatMap(input: Map[Int, Seq[String]]): Map[String, Int] = {
    input
      .flatMap { 
        case (key,values) => values.map(x => (x.toLowerCase(), key)) 
      }
  }
}