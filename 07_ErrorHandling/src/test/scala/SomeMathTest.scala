package main

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class SomeMathTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks {
  test("testAdd") {
    forAll((a: Int, b: Int) => {
      assert(SomeMath().add(a, b) == a + b)
    })
  }
}

