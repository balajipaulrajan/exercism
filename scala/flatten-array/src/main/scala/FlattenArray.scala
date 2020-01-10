object FlattenArray {

  def flatten(xs: List[_]): List[_] = xs match {
    case Nil => Nil
    case ((h: List[_]) :: t) => flatten(h) ++ flatten(t)
    case (null :: t) => flatten(t)
    case (h :: t) => h :: flatten(t)
  }
}