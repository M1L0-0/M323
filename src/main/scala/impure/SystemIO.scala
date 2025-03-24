package impure

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

import cats.effect.{IO, IOApp, Sync}
import cats.effect.kernel.Ref
import cats.syntax.all.*
import cats.effect.unsafe.implicits.global
import scala.concurrent.duration.DurationInt

class SystemIO {
  def printRes(solutions: List[List[(Int, Int)]], startTime: LocalDateTime) = {
    println("Found " + solutions.length + " total solutions. " + solutions.distinct.length + " unique solutions")
    println("Execution finished after[ms]: " + startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS))
  }

  def execute(io: IO[List[List[List[(Int, Int)]]]]): Long = {
    var startTime = LocalDateTime.now()
    var s = io.unsafeRunSync().flatten
    printRes(s, startTime)
    startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS)
  }
}
