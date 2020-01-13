import NumberType.NumberType;
object PerfectNumbers {
  def factorSum(x: Int): Int = {
    (1 until x).filter(x % _ == 0).sum
  }
  def classify(x: Int): Either[String,NumberType] = x match {
    case error if x < 1 => Left("Classification is only possible for natural numbers.")
    case perfect if x == factorSum(x) => Right(NumberType.Perfect)
    case deficient if x > factorSum(x) => Right(NumberType.Deficient)
    case abundant if x < factorSum(x) => Right(NumberType.Abundant)
  }
}

object NumberType extends Enumeration {
  type NumberType = Value
  val Perfect, Deficient, Abundant = Value
}