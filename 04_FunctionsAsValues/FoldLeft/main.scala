import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // FoldLeft
  // Aufgabe 1
  val list = List(1, 2, 3, 4, 5)
  println(list.foldLeft(0)((sum, e) => e + sum))

  // Aufgabe 2
  val stringList = List("Hallo", " ", "Welt", "!")
  println(stringList.foldLeft("")((s, e) => s + e))

  // Aufgabe 3
  val points = List((1, 3), (2, 5), (4, 8), (6, 2))
  val xSum = points.foldLeft(0)((sum, e) => sum + e(0))
  val xAverage = xSum / points.length
  val ySum = points.foldLeft(0)((sum, e) => sum + e(1))
  val yAverage = ySum / points.length
  println("x: " + xAverage + " y: " + yAverage)
