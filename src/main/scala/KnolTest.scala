object KnolTest extends App {

  def getCountOfAlphabets(string: String): Map[Char, Int] = {
    val stringWithoutSpace = string.replaceAll(" ", "").replaceAll("[&$.,]", "")
    stringWithoutSpace
      .groupBy(char => char)
      .map(char => (char._1, char._2.length))
  }

  def getCharWithCount(count: Int) = {}

  val givenString =
    "Knol is a unit of Knowledge & Dus comes from Druksh which is Sanskrit for a tree, hence Knoldus is a tree of Knowledge."
  println(getCountOfAlphabets(givenString))
}
