
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  val people3 = List[String] ("dude", "guy", "rando")
  val people6 = List[String] ("dude", "guy", "rando", "someone", "somebody", "noone")
  val price = 100
  val tipPercentage1 = getTipPercentage(people3)
  val tipPercentage2 = getTipPercentage(people6)
  println(calculateTip(price, tipPercentage1))
  println(calculateTip(price, tipPercentage2))

def calculateTip(total: Float, tipPercent: Int): Float = {
  total / 100 * tipPercent
}

def getTipPercentage(people: List[String]): Int = {
  if people.length > 5 then {
    20
  } else if people.nonEmpty then {
    10
  } else {
    0
  }
}

