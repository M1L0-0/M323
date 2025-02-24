import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Maps
  // Aufgabe 1
  var m1: Map[String, String] = Map("Key" -> "Value")
  println(m1)

  // Aufgabe 2
  m1 = m1 + ("key2" -> "value2")
  println(m1)

  // Aufgabe 3
  m1 = m1.updated("key2", "aDifferentValue")
  println(m1)

  // Aufgabe 4
  println(m1.removed("Key"))

  // Aufgabe 5
  println(m1("Key")) // or with .get() for Option

  // Aufgabe 6
  val valueFromM4: Option[String] = m1.get("no")
  println(valueFromM4)