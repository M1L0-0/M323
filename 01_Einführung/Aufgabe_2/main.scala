
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  val cart = List[String] {"hamlet"}
  val emptyCart = List[String]()
  println(getDiscountPercentage(cart))
  println(getDiscountPercentage(emptyCart))

def getDiscountPercentage(cart: List[String]): Int = {
  if cart.nonEmpty then {
    return 5
  }
  0
}

