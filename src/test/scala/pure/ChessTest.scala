package pure

import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._

class ChessTest extends AnyFlatSpec with should.Matchers {

  "checkMove" should "return true for valid moves" in {
    val testBoard = List((1, 1), (2, 7))
    val moveList = List((4, 6), (3, 2), (5, 8))
    moveList.forall(l => {
      checkMove(testBoard, l)
    }) should be(true)
  }
  "checkMove" should "return false for invalid moves" in {
    val testBoard = List((1, 1), (2, 7))
    val moveList = List((2, 2), (1, 8), (5, 7), (3, 8))
    moveList.forall(l => {
      !checkMove(testBoard, l)
    }) should be(true)
  }
  "incrementField" should "properly increment the column in base cases" in {
    val testFields = List((1, 1), (2, 7), (4, 6), (7, 8))
    testFields.forall(f => {
      val inc = incrementField(f)
      f(0)+1 == inc(0) &&
        f(1) == inc(1)
    }) should be (true)
  }
  "incrementField" should "properly increment the row if the column is 8. Column should be set to 1" in {
    val testFields = List((8, 1), (8, 7), (8, 6), (8, 3))
    testFields.forall(f => {
      val inc = incrementField(f)
      f(1)+1 == inc(1) &&
        inc(0) == 1
    }) should be(true)
  }
  "incrementField" should "return (-1, -1) if field is (8, 8) or out of bounds" in {
    val testFields = List((8, 8), (2, 9), (100, 100), (0, 0), (3, -1))
    testFields.forall(f => {
      val inc = incrementField(f)
      inc(0) == -1 && inc(1) == -1
    }) should be(true)
  }
}
