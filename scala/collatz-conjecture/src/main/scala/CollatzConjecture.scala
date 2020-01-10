import scala.annotation.tailrec
object CollatzConjecture {
 
  def steps(num: Int): Option[Int] = {
    @tailrec
    def loop(num: Int, steps: Int): Int = num match {
      case 1 => steps
      case even if num % 2 == 0 => loop(num / 2, steps + 1)
      case _ => loop((3*num)+1, steps+1)
    }
    if (num > 0) Some(loop(num, 0)) else None
  }

   
}