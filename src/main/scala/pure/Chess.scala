package pure

class Chess {
  def checkStraight(board: List[(Int, Int)], field: (Int, Int)): Boolean = {
    board.filter(b => b(0)==field(0) || b(1)==field(1)).isEmpty
  }

  def checkAcross(board: List[(Int, Int)], field: (Int, Int)): Boolean = {
    board.filter(b => (b(1)-field(1)).abs==(b(0)-field(0)).abs).isEmpty
  }

  def checkMove(board: List[(Int, Int)], field: (Int, Int)): Boolean = {
    checkAcross(board, field) && checkStraight(board, field)
  }

  def incrementField(field: (Int, Int)): (Int, Int) = {
    if field(0) < 8 then (field(0)+1, field(1))
    else if field(1) < 8 then (1, field(1)+1)
    else (-1, -1)
  }

  def findBoard(board: List[(Int, Int)], nextField: (Int, Int), solutions: List[List[(Int, Int)]], i: Int): List[List[(Int, Int)]]= {
    var localBoard = board
    var currentField = nextField
    var s = solutions
    if localBoard.length >= 8 then {
      s = s.appended(board)
    }
    if currentField(0) == -1 && currentField(1) == -1 || currentField(1) > localBoard.length+1 then {
      if board.takeRight(1).isEmpty then return s
      val field = board.takeRight(1).head
      localBoard = board.dropRight(1)
      currentField = field
    }
    if checkMove(board, currentField) then {
      localBoard = localBoard.appended(currentField)
    }
    if i < 3100 then findBoard(localBoard, incrementField(currentField), s, i+1)
    else s
  }
}
