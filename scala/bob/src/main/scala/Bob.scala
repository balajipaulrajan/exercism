object Bob {
  def response(s: String): String = {
    val statement = s.trim();
    if (statement.isEmpty) "Fine. Be that way!"
    else if (isQuestion(statement)) {
      if(isShouting(statement)) "Calm down, I know what I'm doing!"
      else "Sure."
    }
    else if (isShouting(statement)) "Whoa, chill out!"
    else "Whatever."
  }

  def isQuestion(s: String) = s.endsWith("?")

  def isShouting(s: String) = {
    val letters = s.filter(_.isLetter);
    val hasLetters = s.exists(_.isLetter);
    hasLetters && letters.forall(_.isUpper)
  }
}
