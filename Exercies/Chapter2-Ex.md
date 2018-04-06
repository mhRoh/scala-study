## 1. Write a new Centigrade-to-Fahrenheit conversion, Saving each step of the conversion into seperate value.
~~~~~
scala> def cenToFah(x : Double) : Double = {
 var multipled : Double = x * 9
 var divided : Double = multipled / 5
 return divided + 32
}
     |      |      |      | cenToFah: (x: Int)Double
~~~~~
## 2. Modify above function to return Inteager value
~~~~~
scala> def cenToFah(x : Double) : Int = {
 var multipled : Double = x * 9
 var divided : Double = multipled / 5
 return (divided + 32).toInt
}
     |      |      |      | cenToFah: (x: Double)Int
~~~~~
## 3.String interpolation
~~~~~
scala> val float_value = 2.7255
float_value: Double = 2.7255
scala> val dollar = '$'
dollar: Char = $
scala> f"You owe $dollar$float_value%.2f."
res13: String = You owe $2.73.
~~~~~
## 4. Simpler way to write the following?
~~~~
val flag : Boolean = false
val result : Boolean = (flag == false)

scala> val result : Boolean = true
~~~~
## 5. Converting 128
~~~
scala> var inteager = 128
inteager: Int = 128

scala> inteager.toChar
res14: Char = 

scala> inteager.toString
res15: String = 128

scala> var double = inteager.toDouble
double: Double = 128.0

scala> double.asInstanceOf[Int]
res17: Int = 128

scala> double.toInt
res18: Int = 128
~~~
## 6. Regular Expression