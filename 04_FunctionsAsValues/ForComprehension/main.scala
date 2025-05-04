import scala.collection.IndexedSeqView
import scala.math.Ordering.Implicits.*
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // ForComprehension
  // Aufgabe 1
  val numbers = 1 to 10
  println(for (n <- numbers) yield n * n)

  // Aufgabe 2
  val numbers2 = 1 to 20
  println(for (n <- numbers2 if n%2==0) yield n)

  // Aufgabe 3
  val colors = List("Red", "Green", "Blue")
  val fruits = List("Apple", "Banana", "Orange")
  println(for (e <- colors) yield for (f <- fruits) yield e + " " + f)

  // Aufgabe 4
  case class User(name: String, tasks: List[String])
  val users = List(
    User("Alice", List("Task 1", "Task 2", "Task 3")),
    User("Bob", List("Task 1", "Task 4", "Task 5")),
    User("Charlie", List("Task 2", "Task 3", "Task 6"))
  )
  val tasksCompleted = List("Task 1", "Task 3", "Task 5")
  println(for (u <- users) yield for (t <- u.tasks if !tasksCompleted.contains(t)) yield u.name + " " + t)


