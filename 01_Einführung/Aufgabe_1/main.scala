
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  println(wordScoreDeclarative("declarative"))
  println(wordScoreImperative("imperative"))

def wordScoreDeclarative(word: String): Int = {
  var score = 0
  for (c <- word.toCharArray) {
    if c == 'a' then {
      score += 1
    }
  }
  score
}

def wordScoreImperative(word: String): Int = word.count(_ == 'a')

