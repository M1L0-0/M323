package main

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // Errors
  // Übungsaufgabe
  val test = "Mad Men (2007-2015)"
  println(extractName(test))
  println(extractYearEnd(test))

  def extractName(rawShow: String): Option[String] = {
    val bracketOpen = rawShow.indexOf('(')
    for {
      name <- if (bracketOpen != -1 && bracketOpen>=2)
        Some(rawShow.substring(0, bracketOpen-1))
      else None
    } yield name
  }

  def extractYearEnd(rawShow: String): Option[Int] = {
    val dash         = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <- if (dash != -1 && bracketClose > dash)
        Some(rawShow.substring(dash + 1, bracketClose))
      else None
      year    <- yearStr.toIntOption
    } yield year
  }







