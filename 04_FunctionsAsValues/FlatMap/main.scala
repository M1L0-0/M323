import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // FlattenMap
  // Aufgabe 1
  val list = List(List(1, 2), List(3, 4), List(5, 6))
  println(list.flatMap(e => e).map(e => e*2))

  // Aufgabe 2
  val stuff = List(("Max", List("Blau", "Grün")), ("Anna", List("Rot")), ("Julia", List("Gelb", "Blau", "Grün")))
  val flat = stuff.flatMap(e => e(1))
  println(flat.distinct)