
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Aufgabe 1
  println(calculateDiscount5(100))

  // Beispiel 1
  val destinations = List[String] ("Italy", "Spain")
  println(addDestination(destinations, "Switzerland"))

  // Beispiel 2
  val laps = List[Float](12.34, 11.25, 10.75)
  println(getTotalTime(laps))
  println(getAverageTime(laps))


def calculateDiscount5(x: Float): Float = {
  x * 95 / 100
}

def addDestination(destinations: List[String], destination: String): List[String] = {
  destinations.appended(destination)
}

def getTotalTime(laps: List[Float]): Float = {
  var total: Float = 0
  laps.drop(1).foreach(lap => total = total + lap)
  total
}

def getAverageTime(laps: List[Float]): Float = {
  var total: Float = 0
  laps.drop(1).foreach(lap => total = total + lap)
  total / laps.drop(1).length
}