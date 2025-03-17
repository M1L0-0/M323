import pure.Chess

@main
def main(): Unit = {
  var solutions: List[List[(Int, Int)]] = List()
  (1 to 8).foreach(i => {
    solutions = solutions.appendedAll(Chess().findBoard(List(), (i, 1), List(), 0))
  })
  println(solutions)
  println("Found " + solutions.length + " total solutions. " + solutions.distinct.length + " unique solutions")
}

