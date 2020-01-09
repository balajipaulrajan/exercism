object SpaceAge {

  private def calculateAge(ageInSeconds: BigDecimal) : Double => Double = {
    (relativeOrbittalYear: Double) => ((ageInSeconds / 31557600) / relativeOrbittalYear).setScale(2,BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def onEarth(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(1)
  }

  def onMercury(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(0.2408467)
  }

  def onVenus(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(0.61519726)
  }

  def onMars(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(1.8808158)
  }

  def onJupiter(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(11.862615)
  }

  def onSaturn(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(29.447498)
  }
  
  def onUranus(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(84.016846)
  }
  
  def onNeptune(ageInSeconds: BigDecimal): Double = {
    calculateAge(ageInSeconds)(164.79132)
  }
}