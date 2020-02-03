object Hamming {

  def distance(str1: String, str2: String): Option[Int] = {
    def loop(strList1: List[Char], strList2: List[Char], acc: Int): Option[Int] = (strList1, strList2) match {
      case (Nil, Nil) => Some(acc)
      case (Nil, _) => None
      case (_, Nil) => None
      case (x::xs, y::ys) if (x == y) => loop(xs, ys, acc)
      case (x::xs, y::ys) => loop(xs,ys, acc + 1)
    }
    loop(str1.toList, str2.toList, 0)
  }
}