import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

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

  val stringList = List[String]("aTest", "dTest", "cTest")
  println(sortStrings(stringList))

  val objects = List[Ticket](
    Ticket(LocalDateTime.parse("2007-12-03T10:15:30"), 3, "aTest"),
    Ticket(LocalDateTime.now(), 3, "bTest"),
    Ticket(LocalDateTime.parse("2008-12-03T10:15:30"), 2, "cTest")
  )
  sortObjects(objects).foreach(t => println(t.title))

  val tree = Tree[String]("Root", Tree[String]("left", null, Tree[String]("leave1", null, null)), null)
  println(getLeaves(tree, List[Tree[String]]()))

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

// Aufgabe 3.3
def sortStrings(strings: List[String]): List[String] = {
  strings.sortWith((s: String, t: String) => s < t)
}

class Ticket(d: LocalDateTime, p: Int, t: String):
  var date: LocalDateTime = d
  var priority: Int = p
  var title: String = t
end Ticket


// Aufgabe 3.4
def sortObjects(tickets: List[Ticket]): List[Ticket] = {
  var ticketBuffer = tickets.sortWith((s: Ticket, t: Ticket) => s.title < t.title)
  ticketBuffer = ticketBuffer.sortWith((s: Ticket, t: Ticket) => s.priority < t.priority)
  ticketBuffer.sortWith((s: Ticket, t: Ticket) => s.date.isBefore(t.date))
}

// Aufgabe 3.5
case class Tree[A](value:A, left: Tree[A], right: Tree[A])

def getLeaves(tree: Tree[String], list: List[Tree[String]]): List[Tree[String]] = {
  if tree.left == null && tree.right != null then {
    return getLeaves(tree.right, list)
  } else if tree.left == null && tree.right == null then {
    return list.appended(tree)
  } else if tree.left != null then {
    return getLeaves(tree.left, list)
  }
  return list
}


