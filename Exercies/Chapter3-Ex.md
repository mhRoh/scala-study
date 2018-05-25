## 1 Given a string name, write a match expression that will return the same string if nonempty, or else the string "n/a" if it is empty.
~~~~~~
val evalStr:String = null
val evaled = evalStr match {
   case x : String if evalStr != null && evalStr.length() > 0 => evalStr
   case x => "n/a"
}
~~~~~~

## 2. Given a double amount, write an expression to return "greater" if it is more than zero, "same" if it equals zero, and "less" if it is less than zeor. Can you write this with if .. else blocks and match expression
**!!!보니까 match guard에서 사용하는 if 전의 type은 matching에 사용되는 변수의 형을 의미하는 것이었다.**
~~~~~~
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
~~~~~~
## 3. 
~~~~~
~~~~~