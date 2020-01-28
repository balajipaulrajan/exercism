class School {
  type DB = Map[Int, Seq[String]]
  private var localStateDB: DB = scala.collection.immutable.TreeMap() 

  def add(name: String, g: Int) = {
    var seq = localStateDB.getOrElse(g,Seq[String]())
    localStateDB += (g -> (seq :+ name))
  }

  def db: DB = localStateDB

  def grade(g: Int): Seq[String] = localStateDB.getOrElse(g,Seq[String]());

  def sorted: DB = {
    localStateDB.keySet
                .map(key => (key -> localStateDB.get(key).map(seq => seq.sorted).get))
                .toMap
  }
}
