object Bearing extends Enumeration {
 type Bearing = Value
 val East, West, North, South = Value
}

class Robot(val x:Int, val y: Int, val facing: Bearing.Value) {
  
  def bearing = this.facing;
  def coordinates = (this.x, this.y)

  def turnLeft: Robot = this.facing match { 
    case Bearing.North => Robot(Bearing.West,(this.x, this.y))
    case Bearing.South => Robot(Bearing.East, (this.x, this.y))
    case Bearing.East => Robot(Bearing.North, (this.x, this.y))
    case Bearing.West => Robot(Bearing.South, (this.x, this.y))
  }

  def turnRight: Robot =  this.facing match { 
    case Bearing.East => Robot(Bearing.South, (this.x, this.y))
    case Bearing.West => Robot(Bearing.North, (this.x, this.y))
    case Bearing.North => Robot(Bearing.East, (this.x, this.y))
    case Bearing.South => Robot(Bearing.West, (this.x, this.y))
  }

  def advance: Robot = this.facing match {
    case Bearing.East => Robot(Bearing.East, (this.x + 1, this.y))
    case Bearing.West => Robot(Bearing.West, (this.x - 1, this.y))
    case Bearing.North => Robot(Bearing.North, (this.x, this.y + 1))
    case Bearing.South => Robot(Bearing.South, (this.x, this.y - 1))
  }

  def simulate(instructions: String): Robot = {  
    instructions.foldLeft (this) { (robot: Robot, instruction: Char) => instruction match {
        case 'A' => robot.advance
        case 'L' => robot.turnLeft
        case 'R' => robot.turnRight
      } 
    }
  }

  def canEqual(a: Any) = a.isInstanceOf[Robot]

  override def equals(that: Any): Boolean = that match {
   case that: Robot => {
      that.canEqual(this) && 
      this.x == that.x && 
      this.y == that.y &&
      this.facing == that.facing 
   }
   case _ => false
  }
}

object Robot {
  def apply(facing: Bearing.Value, location: (Int,Int)): Robot = {
    new Robot(location._1, location._2, facing)
  }
}