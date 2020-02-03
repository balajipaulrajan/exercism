object Hamming {

  def distance(str1: String, str2: String): Option[Int] = {
    def loop(strList1: List[Char], strList2: List[Char], acc: Option[Int]): Option[Int] = (strList1, strList2) match {
      case (Nil, Nil) => acc
      case (Nil, _) => None
      case (_, Nil) => None
      case (x::xs, y::ys) if (x == y) => loop(xs, ys, acc)
      case (x::xs, y::ys) => loop(xs,ys, acc.flatMap(x => Some(x + 1)))
    }
    loop(str1.toList, str2.toList, Some(0))
  }
}