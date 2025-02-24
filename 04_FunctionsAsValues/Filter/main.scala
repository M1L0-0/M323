import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Filters
  // Aufgabe 1
  val list = List(1, 2, 3, 4, 5)
  println(list.filter(e => e%2 == 0))

  // Aufgabe 2
  val nameList = List("Alice", "Bob", "Charlie", "Diana")
  println(nameList.filter(e => e.getBytes().length > 4))

  // Aufgabe 3
  val numList = List(12, 45, 68, 100)
  println(numList.filter(e => e > 50))

  // Aufgabe 4
  val nameList2 = List("Scala", "ist", "fantastisch")
  println(nameList2.filter(e => e.charAt(0) == 'S'))

  // Aufgabe 5
  case class Buch(titel: String, autor: String, jahr: Int)
  val buecher = List(
    Buch("1984", "George Orwell", 1949),
    Buch("Brave New World", "Aldous Huxley", 1932),
    Buch("Fahrenheit 451", "Ray Bradbury", 1953)
  )
  println(buecher.filter(e => e.jahr < 1950).map(e => e.titel))



