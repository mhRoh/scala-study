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
 즉 각 변수, 상수에 어떤 값을 return한는 Expression(코드들)이 할당된 것이다.
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






