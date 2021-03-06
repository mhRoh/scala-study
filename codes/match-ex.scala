val x=10
val y=20
val max = x > y match {
   case true => x
   case false => y
   }
println("Bigger one is : " + max)

val status = 500
val message = status match {
   case 200 => "ok"
   case 300 => "redirection"
   case 400 => "not valid call"
   case 500 => "server error"
}
println("Server Message : " + message)

val message2 = status match {
   case 200 => "ok"
   case 400 => {
      println("ERROR - we called the service incorrectly")
      "not valid call"
   }
   case 500 => {
     println("ERROR - the service encountered an error")
     "server error"
   }
}
println("Server Message2 : " + message2)

def doClientRequest(request : String) : Int = {
   request match {
      case "POST" => {
         println("Cannot find Rest API for POST")
         400
      }
      case "GET" => {
         println("Your request succeeded")
         200
      }
      case "PUT" => {
         println("Running request failed ")
         500
      }
   }
}

val message3 = doClientRequest("GET") match {
   case 200 => "ok"
   case 400 => "invalid request"
   case 500 => "server error"
}

println(message3)

val day = "MON"
val kind = day match {
   case "MON" | "TUE" | "WEB" | "THU" | "FRI" => "weekday"
   case "SAT" | "SUN" => "weekend"
}
print("Day is " + kind)

val dayAny : Any = 0
val kind2 : Any = dayAny match {
   case "MON" | "TUE" | "WEB" | "THU" | "FRI" => "weekday"
   case 1 | 2 | 3 | 4 | 5  => "weekday"
   case "SAT" | "SUN" => "weekend"
   case 0 | 6 => "weekend"
}

println(s"DayAny is $kind2")

val value : Any = 12180


val realType = value match {
   case x : String => s"'x'"
   case x : Double => f"$x%%.2f"
   case x : Float => f"$x%%2.f"
   case x : Long => s"${x}l"
   case x : Int => s"${x}i"
};

println(s"Type of value $realType")


