package pure

import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._

class ChessTest extends AnyFlatSpec with should.Matchers {

  "checkMove" should "return true for valid moves" in {
    val testBoard = List(Point(1, 1), Point(2, 7))
    val moveList = List(Point(4, 6), Point(3, 2), Point(5, 8))
    moveList.forall(l => {
      l.checkMove(testBoard)
    }) should be(true)
  }
  "checkMove" should "return false for invalid moves" in {
    val testBoard = List(Point(1, 1), Point(2, 7))
    val moveList = List(Point(2, 2), Point(1, 8), Point(5, 7), Point(3, 8))
    moveList.forall(l => {
      !l.checkMove(testBoard)
    }) should be(true)
  }
  "incrementField" should "properly increment the column in base cases" in {
    val testFields = List(Point(1, 1), Point(2, 7), Point(4, 6), Point(7, 8))
    testFields.forall(f => {
      val inc = f.incrementField
      f.x+1 == inc.x &&
        f.y == inc.y
    }) should be (true)
  }
  "incrementField" should "properly increment the row if the column is 8. Column should be set to 1" in {
    val testFields = List(Point(8, 1), Point(8, 7), Point(8, 6), Point(8, 3))
    testFields.forall(f => {
      val inc = f.incrementField
      f.y+1 == inc.y &&
        inc.x == 1
    }) should be(true)
  }
  "incrementField" should "return (-1, -1) if field is (8, 8) or out of bounds" in {
    val testFields = List(Point(8, 8), Point(2, 9), Point(100, 100), Point(0, 0), Point(3, -1))
    testFields.forall(f => {
      val inc = f.incrementField
      inc.x == -1 && inc.x == -1
    }) should be(true)
  }
}
