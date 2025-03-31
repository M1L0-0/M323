package pure

class Point(val x: Int, val y: Int) {
  //Experimental class to display pipelines
  private class PipelineWrapper(val board: Option[List[Point]]) {
    def check(check: String): PipelineWrapper = {
      if this.board.isEmpty then None
      if check == "across" then {
        if checkAcross(this.board.get) then Option(this)
        else None
      }
      else if check == "straight" then {
        if checkStraight(this.board.get) then Option(this)
        else None
      } else None
    }
  }

  def toTuple: (Int, Int) = (x, y)

  private def checkStraight(board: List[Point]): Boolean = {
    !board.exists(b => b.x == this.x || b.y == this.y)
  }

  private def checkAcross(board: List[Point]): Boolean = {
    !board.exists(b => (b.y - this.y).abs == (b.x - this.x).abs)
  }

  def checkMove(board: List[Point]): Boolean = {
    // this.checkAcross(board) && this.checkStraight(board)
    PipelineWrapper(Option(board)).check("across").check("straight").board.isEmpty
  }

  private def increment: Option[Point] = {
    // check out of bounds
    this match {
      case (p) if p.x > 0 && p.x <= 8 && p.y > 0 && p.y <= 8 =>
        if (p.x < 8) Option(Point(p.x + 1, p.y))
        else if (p.y < 8) Option(Point(1, p.y + 1))
        else None
      case _ => None
    }
  }

  def incrementField: Point = {
    val p = this.increment
    if p.isEmpty then Point(-1, -1) else p.get
  }
}

class Chess {
  def findBoard(board: List[Point], nextField: Point, solutions: List[List[Point]], i: Int): List[List[Point]] = {
    var localBoard = board
    var currentField = nextField
    var s = solutions
    if localBoard.length >= 8 then {
      s = s.appended(board).distinct
    }
    if currentField.x == -1 && currentField.y == -1 || currentField.y > localBoard.length + 1 then {
      if board.takeRight(1).isEmpty then return s
      val field = board.takeRight(1).head
      localBoard = board.dropRight(1)
      currentField = field
    }
    if currentField.checkMove(board) then {
      localBoard = localBoard.appended(currentField)
    }
    // Continue recursion if maximum recursion depth is not yet reached
    if i < 3100 then findBoard(localBoard, currentField.incrementField, s, i + 1)
    else s
  }
}