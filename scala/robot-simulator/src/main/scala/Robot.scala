sealed trait Bearing;
case class North() extends Bearing;
case class South() extends Bearing;
case class East() extends Bearing;
case class West() extends Bearing;

sealed trait RobotCommand;
case class Advance() extends RobotCommand;
case class TurnRight() extends RobotCommand;
case class TurnLeft() extends RobotCommand;

class RobotState(val x:Int, val y: Int, val facing: Bearing) {}

class Robot(val state: RobotState) {

  override def equals(x: Any): Boolean = {
   if (x.isInstanceOf[Robot]) {
      val that = x.asInstanceOf[Robot]
      this.state.x == that.state.x && 
      this.state.y == that.state.y &&
      this.state.facing == that.state.facing 
   }
   false
  }
}

object Robot {
  def apply(facing: Bearing, location: (Int,Int)) {
    new Robot(new RobotState(location._1, location._2, facing))
  }
}