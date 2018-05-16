
val message = "not found"

val status = message match {
  case "ok" => 200
  case other => {
    println(s"Couldn't parse $other")
    -1
  }
}
println (s"Response $status ")

val status1 = message match {
  case "ok" => 200
  case _ => {
    println(s"Couldn't parse $message")
    -1
  }
}

println (s"Response $status1 ")

val status2 = message match {
  case "ok" => 200
  case _ => {
    println(s"Couldn't parse $message")
  }
}

println (s"Response $status2 ")


