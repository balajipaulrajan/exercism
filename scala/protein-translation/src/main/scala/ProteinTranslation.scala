object ProteinTranslation {
  def proteins(sequence: String): Seq[String] = {
    val terminatingSet = Set("UAA", "UAG", "UGA");
    val codonMap = Map("AUG" -> "Methionine",
                       "UUU" -> "Phenylalanine", 
                       "UUC" -> "Phenylalanine",
                       "UUA" -> "Leucine", 
                       "UUG" -> "Leucine", 
                       "UCU" -> "Serine", 
                       "UCC" -> "Serine", 
                       "UCA" -> "Serine", 
                       "UCG" -> "Serine",
                       "UAU" -> "Tyrosine",
                       "UAC" -> "Tyrosine",
                       "UGU" -> "Cysteine",
                       "UGC" -> "Cysteine",
                       "UGG" -> "Tryptophan")

    sequence.grouped(3)
            .takeWhile(!terminatingSet.contains(_))
            .map(codonMap.getOrElse(_, "ERROR"))
            .toList
  }
}