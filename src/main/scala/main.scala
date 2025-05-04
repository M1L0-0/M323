import pure.findBoard
import impure.SystemIO

import java.time.LocalDateTime
import cats.effect.IO
import cats.effect.kernel.Ref
import cats.syntax.all.*

@main
def main(): Unit = {
  val printList = true
  // [Presentation]: IO example for Parallel execution AND For comprehension
  val io = for {
    solutions <- Ref.of[IO, List[List[List[(Int, Int)]]]](List())
    execs = (1 to 8).toList.parTraverse { i =>
      findBoard(List(), (i, 1), List(), 0).pure[IO]
    }
    results <- execs
    _ <- solutions.set(results)
    p <- solutions.get
  } yield p

  val startTime = LocalDateTime.now()
  var solutions: List[List[(Int, Int)]] = List()
  //executes pure function in a loop
  (1 to 8).foreach(i => {
    solutions = solutions.appendedAll(findBoard(List(), (i, 1), List(), 0))

  })

  println("Serial execution: ")
  SystemIO().printRes(solutions, startTime)
  println("\nParallel execution: ")
  SystemIO().execute(io)
  SystemIO().requestPrintBoards(solutions)
}

