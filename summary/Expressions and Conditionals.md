# Expression 이란?
- 값을 돌려주는 **{ }** 안의 코드를 Expression이라고 함
- Expression은 함수형 프로그래밍의 근간을 이루는 개념이다.
- Expression은 자신에게 입력된 값을 토대로 연산을 한 값을 입력 변수가 아닌 새로운
변수에 담아 돌려 준다.(Immutable variables)

## Defining values and Variables with Expression
 ~~~~~~~~~
 var <name> : <type> = <literal>
 val <name> : <type> = <literal>
 ~~~~~~~~~
 이전에 Values 와 Variables를 위와 같은 형식으로 정의를 한다고 하였는데 Expression
 이라는 개념을 생각해 본다면 아래와 같이 재정의가 가능하겠다.
 ~~~~~~~
 val <identifier>[: <type>] = <expression>
 var <identifier>[: <type>] = <expression>
 ~~~~~~~
 즉 각 변수, 상수에 어떤 값을 return 하는 Expression(코드들)이 할당된 것이다.
Expression의 여러 예제들은 아래와 같다.
~~~~~~
scala> val amount = { val x = 5 * 20;  x +10 }
amount: Int = 110
scala> { val a = 1; {val b =  a * 2; { val c= b + 4; c}}}
res0: Int = 6
~~~~~~
 두 번째 예제를 보면 각 embrace 안에 새로운 값을 가지는 상수들이 선언되고,
 embrace 안에서는 이전 embrace에서 선언, 계산된 상수를 가지고 연산을 하여 새로운
 값을 생성하고 이를 최종적으로 외부로 return하게 된다.

# Statements
값을 return 하지 않는 expression, 즉 scala 에서는 UNIT Type을 리턴하는 표현을
statement 라고 한다.

# If..Else Expression Blocks
Scala 에서 조건문 block의 사용은 C, Java 에서 와 같이 If..else if.. else
로 사용이 가능하다. 그런데 책의 설명에서는 Scala에서는 if ... else 에 대해서만
인식을 하고 else if 는 다르게 해석을 한다고 한다.
~~~~~~~
if ... else if ... else  == if ... else { if ... else ...}
~~~~~~~

Scala 의 if의 사용법은 아래와 같다.
~~~~~~~
if (<Booblean expression>) <expression>

scala> val condition = if ( 47 % 3 > 0 ) "Not a multiple of 3"
condition: Any = Not a multiple of 3

scala> val condition = if ( 47 % 3 <= 0 ) "Not a multiple of 3"
condition: Any = ()
~~~~~~~
위와 같이 사용이 가능하며 if 에서 사용되는 boolean expression 이 false를 가르키는데
else 구문이 없을 경우에 Any type에 해당되는 값이 return 된다.

if ... else Expression 은 아래와 같이 사용된다. Java 및 C의 것과 거의 비슷하나
위에서 설명하였던 것과 같이 if block 내의 모든 표현은 expression 으로 값을 return
한다.
~~~~~
if (<Booblean expression>) <expression>
else <exprssion>

val x = 10; val y = 20
x: Int = 10
y: Int = 20

scala> val max = if (x > y) x else y
max: Int = 20
~~~~~

# Match Expression
Match Expression 은 C, Java의 switch와 비슷하다.
C, Java에서 제공하는 switch 와 다른 점은 **wild card "catch-all"** 패턴을
지원하고, **break** 를 제공하지 않는다는 것이다.
Match Expression의 사용법은 아래와 같다.
~~~~~~
<expression> match {
  case <pattern match> => <expression>
  [case ...]
}

scala>
val max = (x > y) match {
  case true => x
  case false => y
}
max: Int = 20
~~~~~~

아래의 예시에서는 match block 내에서 여러 statement 와 같이 사용할 경우 curly
brace를 사용하여 이를 표현함을 보여주며 curly brace 내의 맨 마지막 표현은 값을
return 하는 expression이 되어야 한다.
~~~~~~
scala> var status : Int = 500
status: Int = 500
scala> val message : String = status match {
  case 200 => "ok"
  case 400 => {
    println("4xx Not found")
    "4xx error"
  }
  case 500 => {
    println("5xx Server error")
    "5xx Server error"
  }
}
5xx Server error
message: String = 5xx Server error
~~~~~~

## Wild-Card matching (other)
아래는 wild card expression을 사용하는 첫 예제이다. Scala에서 제공하는
match wild card 는 두가지가 있는데, 일단 첫번째로 아래와 같이 **other**가 있다.
~~~~
val message = "not found"

val status = message match {
  case "ok" => 200
  case other => {
    println(s"Couldn't parse $other")
    -1
  }
}

println ("Response status : " + status)

Couldn't parse not found
Response status : -1
~~~~

상기의 예제를 보면 첫번째 case는 match 를 실행할 값이 명시가 되어 있는데 반해
**other**의 경우는 match를 수행할 값이 없음을 알 수 있다. 이 other에 들어가는
값은 message의 값을 그대로 가지게 된다. 그래서 other block안의 print 문에서
other에 들어가 있는 값을 출력할 수 있게 된다.

## Wild-Card matching (_)
두번쨰 wild card는 **_** 이다. **_** wild card 의 경우는 Runtime시에 발생
하는 임의의 값에 대한 이름없는 변수가 되어 wild card match를 수행 역활을 할 수
있는 것이다. 다만 첫번째 **other**와는 다르게 **_**에 할당된 값에 접근을 할 수
가 없다. 아래의 예제를 보자
~~~~~
val status1 = message match {
  case "ok" => 200
  case _ => {
    println(s"Couldn't parse $_")
    -1
  }
}
println (s"Response $status1 ")

 error: error in interpolated string: identifier or block expected
    println(s"Couldn't parse $_")
                            ^
 error: ')' expected but '}' found.
  }
  ^
~~~~~
**_** block 안에서 **_**를 변수처럼 생각하여 해당 변수에 할당된 값을 출력해
보려 하면 위와 같은 에러가 발생을 하게된다.

여기까지 와서 일단 Scala에서 제공을 하는 match ~~~ case 를 생각해 보면 이는 if .. else
의 확장이라고 보아도 좋을 듯하다. 이유는 break를 제공하지 않아 모든 case문을 하나
씩 수행하여 봐야 될 것이다. 만약에 match가 되는 block을 만나게 되면 이 match block
을 벗어나기 위한 수단이 필요할 터인데 다른 언어에서는 이를 **break**로 수행을 하였
는데 Scala에서는 특정 값을 return 하는 것으로 이를 수행하기 때문이고, 이는 if, else
와 같기 때문이다. if , else 의 경우는 block 안에 선언이 되어 있는 expression이
특정 값을 return하지 않더라도 무조건 Unit()을 리턴하게 되어 있으니 말이다.

위의 match wild-card 예제에서 **_** block 안에서 **-1** 을 제거하면 어떤 일이
벌어질까 한번 생각해 보자 아마도 println 문은 Unit 을 출력하게 될 것이다.
~~~~~
val status2 = message match {
  case "ok" => 200
  case _ => {
    println(s"Couldn't parse $message")
  }
}

println (s"Response $status2 ")

Couldn't parse not found
Response ()
~~~~~

실제 수행 결과 Unit을 나타내는 **()**이 출력 되었다. 이렇게 되는 이유는 특정값을
return하지 않는 expression의 경우는 Unit()을 return하게 되어 있기 때문이다.
## Matching with Pattern Guards





