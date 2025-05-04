import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Tuples
  // Aufgabe 1
  println(getWeather)

  // Aufgabe 2
  val data = (("rainy", LocalDateTime.now(), 32), ("cloudy", LocalDateTime.now(), 12), ("rainy", LocalDateTime.now(), 0))
  println(for (d <- data.toList if d(0) == "rainy") yield d )

def getWeather: Tuple = {
  ("rainy", LocalDateTime.now(), 32)
}