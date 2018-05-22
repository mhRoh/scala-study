# Loop
Scala 에서 제공하는 for loop는 python의 for loop와 많이 닮아 있다.
python 에서는 range 라고 하는 메소드를 제공하여 for loop 가 동작하는 범위를 지정할
수 있는데 scala에서는 이에 대해 to, until 을 제공한다.
일단 for loop의 기본 형식을 보자
~~~~~
<starting integer> [to|until] <ending integer> [by increment]
~~~~~
위의 형식에 의거하여 1 부터 7 까지 출력하는 예제를 보면 아래와 같다.
~~~~~
println("For loop using range of 'to'")
for (x <- 1 to 7) { println(s"Day$x") }
~~~~~
상기의 예제에서 **()** 안에 to를 사용하였을 경우 7까지를 포함한 숫자가 아래와 같이
출력되게 된다.
~~~~~
For loop using range of 'to'
Day1
Day2
......
Day7
~~~~~
다음으로 until을 사용하였을 때의 출력을 보자. 
~~~~~
println("For loop using range of 'until'")
for (x <- 1 until 7 ) { println(s"Day$x") }
~~~~~
상기의 코드의 결과를 보면 아래와 같이 출력이 되는데, **to** 를 사용하였을 때와는 달리
Day7이 출력되지 않는 것을 알 수 있다. **until** 의 영어의 의미는 무엇의 바로 직전까지
라는 의미이므로 이런 것은 당연하겠다.
~~~~~
For loop using range of 'until'
Day1
Day2
......
Day6
~~~~~
우리가 C언어에서 for loop를 배울 떄 for loop 를 중첩시킬 수가 있었다. 바로 아래와 같이
~~~~~~
for (.....) {
  for (....) {
  }
 }
~~~~~~
당연히 Scala에서 같은 형식으로 사용할 수 있다. 아래의 예제는 곱하기를 1단에서 9단까지
출력을 할 것이다.
~~~~~~
for (x <- 1 until 10 ) {
  for (y <- 1 until 10) {
      println(s"$x * $y = " + (x*y))
  }
}
~~~~~~
그런데 Scala에서는 저렇게 for loop를 중첩시키는 부분에 boiler plate가 들어가는 것이
너무 싫었나 보다 아래와 같이 간단하게 표현이 가능하도록 만들었다.
~~~~~~
println("Multiple Iterators in For Loop")
for (x <- 1 to 9; y <- 1 to 9) {
      println(s"$x * $y = " + (x*y))
}
~~~~~~
상기의 예제의 결과는 이전의 예제와 동일한 결과를 보인다.

Scala 에서의 for loop는 다른 언어에 제공하지 않는 한가지 특성이 있다.
~~~~~~ 
println("Yield keywords in For Loop")
val result = for (x <- 1 to 9; y <- 1 to 9) yield {
  val multiple = x*y
  s"$x*$y=$multiple"
}
~~~~~~ 






