import scala.annotation.tailrec
object MatchingBrackets {
 
  def isPaired(expr: String): Boolean = {
    val bracketMap: Map[Char,Char] = Map('{' -> '}','[' -> ']','(' -> ')')
    val closeBracketSet: Set[Char] = Set('}',']',')')
    val brackets: List[Char] = expr.filter(c => (bracketMap.contains(c) || closeBracketSet.contains(c))).toList

    @tailrec
    def loop(bracketList: List[Char], accStack: List[Char]): Boolean = (bracketList, accStack) match {
      case (Nil, Nil) => true
      case (h::t , acc) if (bracketMap.contains(h)) => loop(t, h::acc)
      case (h::t, ob::acc) if(closeBracketSet.contains(h)) && bracketMap(ob) == h  => loop(t,acc)
      case _ => false
    }

    loop(brackets,Nil)
  }
}
