object Pangrams {
  def isPangram(input: String): Boolean = {
    input.toLowerCase().filter(_.isLetter).toSet.size == 26
  }
}

