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
println("Multiple Iterators in For Loop")
for (x <- 1 until 10 ) {
  for (y <- 1 until 10) {
      println(s"$x * $y = " + (x*y))
  }
}
~~~~~~
그런데 Scala에서는 저렇게 for loop를 중첩시키는 부분에 boiler plate가 들어가는 것이
너무 싫었나 보다 아래와 같이 간단하게 표현이 가능하도록 만들었다. 위, 아래 두 예제는 
같은 결과를 보인다.
~~~~~~
println("Multiple Iterators in For Loop")
for (x <- 1 until 10; y <- 1 until 10) {
      println(s"$x * $y = " + (x*y))
}
~~~~~~
상기의 예제의 결과는 이전의 예제와 동일한 결과를 보인다.

**그런데 iterator 내에 변수는 꼭 하나만 사용할 수 있는 것일까?**


Scala 에서의 for loop는 다른 언어에 제공하지 않는 한가지 특성이 있다.
~~~~~~ 
println("Yield keywords in For Loop")
val result = for (x <- 1 to 9; y <- 1 to 9) yield {
  val multiple = x*y
  s"$x*$y=$multiple"
}
print(result)
~~~~~~ 
상기의 예제의 경우는 for loop 안의 expression이 return 하는 값을 yield 라는
키워드를 통해 for loop 외부에서 받아 처리를 할 수 있도록 한 것이다. Java 등의 다른
 언어에서는 보통 for loop 의 내부에서 처리되는 값을 loop 밖에서 처리하기 위해서는
  List, Map 등의 Collection 을 이용하여 loop 내에서 받아들이고 해당 List, Map에 
  다시 접근하여 처리하는 것이 일반적인 루틴이었는데 Scala에서는 yield라는 명령을
  제공함으로써 이를 좀 더 간단하게 처리 할 수 있도록 하였다.
 상기 예제의 실행 결과는 아래와 같다. 
 ~~~~~
 Yield keywords in For Loop
 Vector(1*1=1, 1*2=2, 1*3=3, 1*4=4, 1*5=5, ....., 9*9=81)
 ~~~~~
 **그런데 yield를 통해 loop 내에서 return 할 수 있는 Collection은 항상 Vector 만 가능한가?
 이는 좀 더 찾아봐야 하겠다.**
 
 지금까지 for loop의 사용법에 대해 보았는데 한가지 빠진 것이 있다. 일반적으로 Java, C등에서
 제공하는 for loop의 문법에서는 for loop 의 argument가 얼마의 크기로 증가 또는 감소하는 지를
 표현하는 것이 있었다. 아래와 같이
 ~~~~~
for (int x = 0; x < 10; x++ <---  이거 말하는 거다.) 
 ~~~~~
 그런데 Scala에서는 이런 것이 없을까? 없으면 큰 문제일 텐데 없을리가 있나. 다음 예제를 보자.
 ~~~~~
 println("Using Iterator-To by Increment")
 for (x <- 1 to 10 by 2) {
   print(s"$x,")
 }
 
 println("\nUsing Iterator-Until by Decrement")
 for (x <- 10 until 1 by -2) {
   print(s"$x,")
 }
 ~~~~~
 각 Iterator 표현에 by를 통하여 x 가 특정 값에 도달 할 때 까지 어떤 간격으로 증가, 감소하는지를 표현한다. 
 상기의 예의 결과는 아래와 같다.
 ~~~~~
Using Iterator-To by Increment
1,3,5,7,9,
Using Iterator-Until by Decrement
10,9,8,7,6,5,4,3,2, 
 ~~~~~
 
 # Iterator Guards
Match 표현에서 if 문을 이용하는 Pattern Guards를 사용할 수 있었는데 For Loop 에서도 이와 비슷한 것이 있다.
Iterator Guard의 기본 형식은 아래와 같다.
~~~~~
for (<identifier> <- <iterator> if <Boolean expression>)
~~~~~
~~~~~
val threes = for (i <- 1 to 20 if i % 3 == 0) yield i
println(threes)
~~~~~
상기의 예제는 3의 배수를 구하는 예제이다. iterator 안에 if expression을 넣어 조건 처리를 하였다.
iterator guard가 항상 iterator 내에서만 사용 가능한 것은 아니다. 아래의 예제를 보자.
~~~~~
val quote = "Faith,Hope,,Charity,Generosity"
for { t <- quote.split(",") if t != null if t.size > 0 } {
  println(t)
}

Faith
Hope
Charity
Generosity
~~~~~


 
 






