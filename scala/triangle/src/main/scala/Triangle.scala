class Triangle(x: Double, y: Double, z: Double) {
  def equilateral = legal && (x == y) && (x == z)
  def isosceles = legal && ((x == y) || ( x == z ) || (y == z))
  def scalene = legal && !isosceles
  def legal = (x * y * z != 0) && ((x+y) > z) && ((x+z) > y) && ((y+z) > x)
}
object Triangle{
  def apply(x: Double, y: Double, z: Double) = new Triangle(x,y,z)
}