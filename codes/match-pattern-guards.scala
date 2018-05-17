val  response: String = null

val result = response match {
  case s if s != null => println(s"Received '$s'")
  case s => println("Error! Received a null response")
}

println(s"Result $result")
