
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  var input = String()
  val wordMap = scala.collection.mutable.Map[String, Int]()
  while true do {
    input = scala.io.StdIn.readLine()
    val score = getScore(input)
    println(score)
    wordMap.put(input, score)
    println(wordMap.toSeq.sortBy(_._2))
  }

def getScore(word: String): Int = {
  var score = 0
  word.toCharArray.foreach(char => {
    if (char != 'a') then {
      score = score + 1
    }
  })
  score
}

