# var, val
 var 의 경우는 후에 변경 가능성이 있는 변수를 선언하기 위해 필요하다.
  즉 var num1 = 3 이라고 한 후 num1 = 4 처럼 변수의 값을 새로 정의할 수 있다는 의미이다.
  ~~~~
  scala> var num1 = 3
   num1: Int = 3

  scala> num1 = 4
   num1: Int = 4
  ~~~~~
  
 val 의 경우는 한번 값이 정해 진 후에는 해당 주소의 값을 변경 하지 못하는 상수를 의미 한다. 
  즉 val num1 = 3 이라고 한 후 num1 = 4로 하였을 경우 에러가 발생한다.
  
 ~~~~~
  scala> val num1 = 3
   num1: Int = 3
  scala> num1 = 4
   <console>:12: error: reassignment to val
       num1 = 4
            ^
 ~~~~~

 아래의 형식으로 변수와 상수를 선언하여 사용하는 것이 정석이라고 한다.
 ~~~~~~~~~
 var <name> : <type> = <literal>
 val <name> : <type> = <literal>
 ~~~~~~~~~
 상기의 예시에서 보면 name, type, literal 이라는 부분이 나오는데
 name 은 변수, 상수의 명, type은 변수, 상수가 가지게 될 형식을 의미(이 type의 경우
 모든 구현이 Class로 구현되어 있다), literal은 변수, 상수가 가지게 될 프로그램 내에서
 명시된 값을 의미한다.

# 함수
Scala에서의 함수는 Python에서 처럼 **def** 를 이용하여 선언 할 수 있다.
  ~~~~~
  def func1(val: Int) : Double = {
    val + 0.1
  }
  ~~~~~
상기의 예시로 든 것이 기본적으로 사용되는 함수 선언 방법 같은데, 각 부분에 대한 내 생각을 정리해 보면
   
**def**는 함수 선언 syntax,

**func1** 은 함수 이름,

**val : Int** 는 val 이라는 parameter 인자 변수를 정의하는데 Int 형으로 받겠다 라는 선언,

**: Double** 부분은 이 함수의 return 값의 형은 Double이야,

**= { val + 0.1 }** 은 실제 구현 부분이다.
~~~~~
scala> def func2(val1: Double) = {
    val1 + 0.1
}
func2: (val1: Double)Double  
~~~~~
위와 같이 return 타입을 명시하지 않고 사용 할 수도 있는데 위의 기본형이라고
설명한 것과 비교를 해 보면 함수의 반환 Type을 선언하는 **: Double** 이
사라져 있는데 이는 Scala 에서 반환형에 대한 추론을 제공하기에 가능한 부분이라 하겠다.
(함수의 반환형의 경우는 recursive하게 함수를 호출 할 경우에는 꼭 명시를
해주어야 하는 것 같다.)

함수 선언시 인자를 받지 않는 경우는 아래와 같은 방식으로 함수 선언을 할 수 있다.
또한 아래의 예시에서는 함수의 구현부가 한 줄로 이루어져 있기에 embrace '{' 를
제거하고 선언을 할 수가 있다.

~~~~~~~~~
scala> def printFunc() : String = "Scala is fun"
printFunc: ()String
~~~~~~~~~
인자가 없는 함수의 경우 Java와는 다르게 () 를 아래처럼 무시하고 사용이 가능하다.
~~~~~~~~~
scala> val str = printFunc
str: String = Scala is fun
~~~~~~~~~

~~~~~
scala> def func2(val1: Double) = {
    val1 + 0.1
}
func2: (val1: Double)Double
~~~~~

몇일 지나서 위 func2를 다시 보았다. Java와 다른 점은... return이 없네?
return이 없구나.  그럼 이 Scala라는 놈은 함수가 값을 return 할 것인지
아닌지를 어떻게 구분을 하지? 이것도 Scala complier 가 추론을 한다고 생각해야
하나? 일단 아래의 예시를 한번 보자.

~~~~~~~
scala> def greet() = println("Hello. World!")
greet: ()Unit
~~~~~~~

greet: ()Unit 이라고 나오는 것을 보아 greet과 같이 return 값이 없을 경우는
Unit 으로 표현을 하는 것 같다. 실제로 찾아보니 **Unit은 Java의 void와 같은
역활**을 하는 것으로 나타났다.

즉 함수에서 변수 및 상수가 소비되는 형태의 함수의 경우라 하더라도 Unit을 명시적으로
선언을 해주지 않으면 Scala가 이를 추론하여 알아서 해당 함수가 어떤 형식의 값을
리턴하는지 알아서 complie 시에 결정을 해 준다. 아래의 경우를 보면 어떻게 보면

~~~~~~~~~~
scala> def userInputGreeting(welcome : String) = "I say " + welcome
userInputGreeting: (welcome: String)String
~~~~~~~~~~

다른 언어에서는 "I say" + welcome 이라는 행위로 해당 함수는 그냥 변수를 소모한다고
볼 수 있는데 Scala는 이를 굳이 추론을 하여 String을 반환하는 함수라고 인식을 한다.

뭐 명시적으로 return 이 없는 함수를 선언을 아래와 같이 할 수 있으니 별 상관은 없다.
(왠만하면 Return 값을 명시적으로 선언을 하도록 하자. 그것이 가독성에도 좋을 것이다.)
~~~~~~~
scala> def greet2() : Unit = println("Hello, World2!")
greet2: ()Unit
~~~~~~~


 
