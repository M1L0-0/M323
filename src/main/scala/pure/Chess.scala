package pure

import scala.annotation.tailrec

def check(check: String, field: (Int, Int), board: Option[List[(Int, Int)]]): Option[List[(Int, Int)]] = {
  if board.isEmpty then None
  else if check == "across" then {
    if checkAcross(board.get, field) then board
    else None
  }
  else if check == "straight" then {
    if checkStraight(board.get, field) then board
    else None
  } else None
}

// [Presentation]: filters
private def checkStraight(board: List[(Int, Int)], field: (Int, Int)): Boolean = {
  !board.exists(b => b(0) == field(0) || b(1) == field(1))
}

private def checkAcross(board: List[(Int, Int)], field: (Int, Int)): Boolean = {
  !board.exists(b => (b(1) - field(1)).abs == (b(0) - field(0)).abs)
}

def checkMove(board: List[(Int, Int)], field:(Int, Int)): Boolean = {
  // this.checkAcross(board) && this.checkStraight(board)
  // [Presentation]: Pipeline example
  check("across", field, check("straight", field, Option(board))).isDefined
}

// [Presentation]: matcher
private def increment(field: (Int, Int)): Option[(Int, Int)] = {
  field match {
    case f if f(0) > 0 && f(1) <= 8 && f(1) > 0 && f(1) <= 8 =>
      if (field(0) < 8) Option((f(0) + 1, f(1)))
      else if (field(1) < 8) Option((1, f(1) + 1))
      else None
    case _ => None
  }
}

def incrementField(field: (Int, Int)): (Int, Int) = {
  val p = increment(field)
  if p.isEmpty then (-1, -1) else p.get
}

// [Presentation]: Recursion: Show difference with and without tailRec to find last solution
// @tailrec
def findBoard(board: List[(Int, Int)], nextField: (Int, Int), solutions: List[List[(Int, Int)]], i: Int): List[List[(Int, Int)]] = {
  var localBoard = board
  var currentField = nextField
  var s = solutions
  if localBoard.length >= 8 then {
    s = s.appended(board).distinct
  }
  if currentField(0) == -1 && currentField(1) == -1 || currentField(1) > localBoard.length + 1 then {
    if board.takeRight(1).isEmpty then return s
    val field = board.takeRight(1).head
    localBoard = board.dropRight(1)
    currentField = field
  }
  if checkMove(board, currentField) then {
    localBoard = localBoard.appended(currentField)
  }
  // Continue recursion if maximum recursion depth is not yet reached
  if i < 10000 then findBoard(localBoard, incrementField(currentField), s, i + 1)
  else s
}
