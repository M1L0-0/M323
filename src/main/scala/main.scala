
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Aufgabe 1
  //  Regel 1: Nur ein return Wert | Regel 2: Nur abhängikeit zu input | Regel 3: isolation
  // Aufgabe 1.1: 1: Ja, 2: Nein, 3: Nein || impure
  // Aufgabe 1.2: 1: Ja, 2: Ja, 3: Ja || pure
  // Aufgabe 1.3: 1: Ja, 2: Ja, 3: Ja || pure
  // Aufgabe 1.4: 1: Ja, 2: Nein, 3: Ja || impure
  // Aufgabe 1.5: 1: Ja, 2: Ja, 3: Ja || pure
  // Aufgabe 1.6: 1: Ja, 2; Jein, 3: Nein || impure
  val list = List[Float](1, 2, 3, 4)
  println(next(list, 0))
  println(median(list))


// Aufgabe 2: 1.1
def addToCart(item: String, cartItems: List[String]): List[String] = {
  cartItems.appended(item)
}
//Aufgabe 2: 1.4
def multiplyWithRandom(number: Double, randomNum: Double): Double = {
  number * randomNum
}
// Aufgabe 2: 1.6 (not easily solvable: abhängikeit zu konsole)
def printAndReturnString(str: String): String = {
  println(str) // not pure
  str
}

// Aufgabe 3.1
def next(nums: List[Float], total: Float): Float = {
  if nums.isEmpty then { return total}
  next(nums.drop(1), nums.head + total)
}

// Aufgabe 3.2
def median(nums: List[Float]): Float = {
  val sorted = nums.sortWith((s: Float, t: Float)
  => s < t)
  val middle: Int = sorted.length/2
  sorted(middle)
}




