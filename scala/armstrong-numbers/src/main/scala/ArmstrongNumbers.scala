object ArmstrongNumbers {
  def isArmstrongNumber(x: Int): Boolean = {
    val numString = x.toString()
    val length = numString.length();
    x == numString.map(c => Math.pow(c.asDigit, length)).sum
  }
}