import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Maps und Filters
  // Aufgabe 1
  case class Mitarbeiter(name: String, abteilung: String, gehalt: Int)
  val mitarbeiter = List(
    Mitarbeiter("Max Mustermann", "IT", 50000),
    Mitarbeiter("Erika Musterfrau", "Marketing", 45000),
    Mitarbeiter("Klaus Klein", "IT", 55000),
    Mitarbeiter("Julia Gross", "HR", 40000)
  )
  println(mitarbeiter.filter(e => e.gehalt >= 50000).map(e => e.name.split(" ")(0).toUpperCase))

  // Aufgabe 2
  var kurse = List(
    "Programmierung in Scala",
    "Datenbanken",
    "Webentwicklung mit JavaScript",
    "Algorithmen und Datenstrukturen"
  )
  kurse = kurse.filter(e => e.toLowerCase().contains("daten")).map(e => e.replace(" ", "")).sortWith((s: String, t: String) => s < t).sortWith((s: String, t: String) => s > t)
  println(kurse)

