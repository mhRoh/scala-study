# val, var
	- var(value) 의 경우는 후에 변경 가능성이 있는 변수를 선언하기 위해 필요하다.
  즉 val num1 = 3 이라고 한 후 num1 = 4 처럼 변수의 값을 새로 정의할 수 있다는 의미이다.
  
	- val(variable) 의 경우는 한번 값이 정해 진 후에는 해당 주소의 값을 변경 하지 못하는 상수를 의미 한다. 
  즉 val num1 = 3 이라고 한 후 num1 = 4로 하였을 경우 에러가 발생한다.
  ~~~~
  scala> val num1 = 3
  scala> num1 = 4
  ~~~~
  

# 함수
     -   Scala에서의 함수는 python에서 처럼 def 를 이용하여 선언 할 수 있다.
     -   함수 선언 기본 형          def func1(val: Int) : Double = val + 0.1          상기의 예시로 든 것이 기본적으로 사용되는 함수 선언 방법 같은데, 각 부분에 대해 내 생각을          정리해 보면 def는 함수 선언 syntax, func1 은 함수 이름, val : Int 는 val 이라는 parameter 인자 변수                    를 정의하는데 Int 형으로 받을 꺼야 라는 선언 : Double 부분은 이 함수의 return 값의 형은          Double이야,  = val + 0.1 은 실제 함수의 operation 부분이다.
        이외에도 함수의 선언 방법에는 여러가지가 있는 듯 하다.
           def func2(val: Double) = val + 0.1 과 같이 return 타입을 명시하지 않고 Scala로 Complier로 하여금          추론을 하게 만들 수 있기도 하는데 위의 기본형이라고 설명한 것 과 비교를 해 보면  실제 함수의            operation 선언 부분에 ": Double" 이 사라져 있는데 ":" 이 부분의 의미는 함수의 return 형을 선언한          다는 의미가 있는 것 같다.           인자를 받지 않는 경우는                   def printFunc() : String = "Scala is fun." 또는 def printFunc() = "Scala"            와 같이 사용이 가능하며 인자가 없는 관계로                       "val str = printFunc"           와 같이 괄호 없이 사용이 가능하다.

          Python 및 Java8에서 처럼 lamba을 scala는 제공하기도 한다.          (x: int): Int=x+x   <--- 요렇게 쓰면 안된다.           스칼라에서의 람다식은  변수 => operation 으로 선언을 한다.            (x: int) => x+x
