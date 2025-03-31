package impure

import pure.Point

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

import cats.effect.IO
import cats.effect.unsafe.implicits.global

class SystemIO {
  def printRes(solutions: List[List[pure.Point]], startTime: LocalDateTime): Unit = {
    println("Found " + solutions.length + " total solutions. " + solutions.distinct.length + " unique solutions")
    println("Execution finished after[ms]: " + startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS))
  }

  def execute(io: IO[List[List[List[Point]]]]): Long = {
    val startTime = LocalDateTime.now()
    var s: List[List[pure.Point]]  = List()
    s = io.unsafeRunSync().flatten
    printRes(s, startTime)
    startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS)
  }
}
