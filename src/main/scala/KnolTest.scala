import scala.collection.mutable.ArrayBuffer

object KnolTest extends App {

  def getCountOfAlphabets(string: String): Map[Char, Int] = {
    val stringWithoutSpace = string.replaceAll(" ", "").replaceAll("[&$.,]", "")
    stringWithoutSpace
      .groupBy(char => char)
      .map(char => (char._1, char._2.length))
  }

  def getCharWithCount(string: String, count: Int): String = {
    val resultMap: Map[Char, Int] = getCountOfAlphabets(string)
    val list = ArrayBuffer[Char]()
    for ((k, v) <- resultMap) {
      if (v == count) list += k
    }
    list.mkString
  }

  val givenString =
    "Knol is a unit of Knowledge & Dus comes from Druksh which is Sanskrit for a tree, hence Knoldus is a tree of Knowledge."
  println(getCountOfAlphabets(givenString))
  println(getCharWithCount(givenString, 4))
}
