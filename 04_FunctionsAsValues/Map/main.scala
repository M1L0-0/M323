import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Maps
  //Aufgabe 1
  val list = List[Int](1, 2, 3, 4, 5)
  println(list.map(e => e*2))

  //Aufgabe 2
  val stringList = List("Alice", "Bob", "Charlie")
  println(stringList.map(e => e.toUpperCase))

  //Aufgabe 3
  val list3 = List(12, 45, 68, 100)
  println(list3.map(e => e/2))

  //Aufgabe 4
  val adressen = List(
    Adresse("Hauptstrasse", 10, "12345", "Musterstadt"),
    Adresse("Nebenstrasse", 5, "23456", "Beispielburg")
  )
  println(adressen.map(e => e.strasse + " " + e.hausnummer + ", " + e.postleitzahl + " " + e.stadt))

  //Aufgabe 5
  val namen = List("Max Mustermann", "Erika Mustermann")
  println(namen.map(e => e.split(" ")(0).toUpperCase()))


// Aufgabe 4
case class Adresse(strasse: String, hausnummer: Int, postleitzahl: String, stadt: String)



