object Bob {
  def response(statement: String): String = {
    if (statement.trim.isEmpty) "Fine. Be that way!"
    else if (statement.trim.last == '?') {
      if(statement.filter(_.isLetter).isEmpty || !statement.filter(_.isLetter).forall(_.isUpper)) "Sure."
      else "Calm down, I know what I'm doing!"
    }
    else if (!statement.filter(_.isLetter).isEmpty && statement.filter(_.isLetter).forall(_.isUpper)) "Whoa, chill out!"
    else "Whatever."
  }
}
