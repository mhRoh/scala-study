val evalStr:String = null
def problem1(str:String):String = {
  str match {
    case x: String if str != null && str.length() > 0 => evalStr
    case x => "n/a"
  }
}
println (s"Problem1 Result : ${problem1(evalStr)}")

val amount : Double = 0.0
def problem2_ifelse(amount : Double) : String = {
  if (amount > 0.0) "greater"
  else if (amount < 0) "less"
  else "same"
}
def problem2_match(amount : Double) : String = {
  amount match {
    case result: Double if amount > 0.0 => "greater"
    case result: Double if amount < 0.0 => "less"
    case result => "same"
  }
}
println(s"Problem 2's Solution fof if...else and match : ${problem2_ifelse(amount)}, ${problem2_match(amount)}")

val color:String = "blue"
def problem3_match1(color:String) : String = {
  color match {
    case "cyan" => "0x313982"
    case "magenta" => "0x321771"
    case "yellow" => "0x123833"
    case _ => "n/a"
  }
}
def problem3_match2(color:String) : String = {
  color match {
    case "cyan" => "0x313982"
    case "magenta" => "0x321771"
    case "yellow" => "0x123833"
    case other => s"$other is not defined"
  }
}
println (s"Answer to Problem3 : ${problem3_match1(color)}, ${problem3_match2(color)}")

def problem4_forloop(from:Int, goal:Int) : Unit = {
  for (i <- from to goal by 1)
    if (i % 5 == 0) println(s"$i") else print(s"$i,")
}
problem4_forloop(1, 100)

