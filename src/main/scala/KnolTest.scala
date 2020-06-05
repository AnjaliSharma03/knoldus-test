import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object KnolTest extends App {

  val givenString =
    "Knol is a unit of Knowledge & Dus comes from Druksh which is Sanskrit for a tree, hence Knoldus is a tree of Knowledge."

  def getCharWithCount(string: String, count: Int): String = {
    val resultMap: List[(Char, Int)] = getCountOfAlphabets(string)
    val list = ListBuffer[Char]()
    for ((k, v) <- resultMap) {
      if (v == count) list += k
    }
    list.mkString
  }

  def getCountOfAlphabets(string: String): List[(Char, Int)] = {
    val listBufffer = ListBuffer.empty[(Char, Int)]
    val stringWithoutSpace =
      string.toLowerCase.replaceAll(" ", "").replaceAll("[&$.,]", "")
    val charList = stringWithoutSpace.distinct.toList
    val unorderedFrequency = stringWithoutSpace
      .groupBy(identity)
      .map(char => (char._1, char._2.length))
    charList.foreach { char =>
      unorderedFrequency
        .get(char)
        .foreach(count => listBufffer.append((char, count)))
    }
    listBufffer.toList
  }
  println(getCountOfAlphabets(givenString))
  println(getCharWithCount(givenString, 2))
}
