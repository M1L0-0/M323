package impure

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

import scala.io.StdIn.readLine

import cats.effect.IO
import cats.effect.unsafe.implicits.global

class SystemIO {
  def printRes(solutions: List[List[(Int, Int)]], startTime: LocalDateTime): Unit = {
    println("Found " + solutions.length + " total solutions. " + solutions.distinct.length + " unique solutions")
    println("Execution finished after[ms]: " + startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS))
  }

  def drawBoard(board: List[(Int, Int)]): String = {
    var s = " ---- ---- ---- ---- ---- ---- ---- ---- \n"
    (1 to 8).foreach(i => {
      var row = ""
      val cPos = board.filter(q => i == q(0)).head(1) - 1
      (1 to cPos).foreach(ii => row += "|    ")
      row += "| ♕ |"
      (cPos+1 to 7).foreach(ii => row += "    |")
      s += row + "\n ---- ---- ---- ---- ---- ---- ---- ---- \n"
    })
    s
  }

  def requestPrintBoards(solutions: List[List[(Int, Int)]]): Unit = {
    println("\nDo you want to print all unique solutions? (y/N)")
    val yon = readLine()
    if yon.toLowerCase() == "y" then solutions.distinct.foreach(b => println(drawBoard(b)))
  }

  // [Presentation]: higher order function
  def execute(io: IO[List[List[List[(Int, Int)]]]]): Long = {
    val startTime = LocalDateTime.now()
    var s: List[List[(Int, Int)]]  = List()
    s = io.unsafeRunSync().flatten
    printRes(s, startTime)
    startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS)
  }
}
