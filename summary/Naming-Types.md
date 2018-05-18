# Naming
변수, 상수 명을 Scala에서 어떻게 사용하는 가에 대한 내용이다.
다른 언어의 경우는 변수/상수명을 사용하는 것에 많은 제약이 있는 편이다. 그런데
이 Scala의 경우는 많은 금지된 것들이 가능하다. 심지어는 아래와 같은 것도 가능하다.

~~~~~~~~~
scala> val * = 3.3
*: Double = 3.3
~~~~~~~~~

이건 너무 파격적이지 않은가? 이러한 특성 때문은 코드 가독성을 더 높일 수 있는 코드를
작성 할 수 있다고 한다.
일단 변수명으로 사용가능한 것을 보면 문자, 숫자 그리고 special operator character 라고 한다.
여기 Special operator character의 범위는 Unicode로 따진다면 \u0020 ~ \u007F,
그리고  **[] .** 을 제외한 Unicode Symbol 과 수학 기호까지 포함을 한다.

아래같은 것은 위에 이야기 하는 것 처럼 안되는 것이고.

~~~~~~~~~~
scala> val [] = "Pararar"
<console>:1: error: illegal start of simple pattern
       val [] = "Pararar"
           ^
scala> <console>:11: error: not found: value a
       val a.b = "String"
           ^
scala> val 50Cent = 50
<console>:1: error: Invalid literal number
       val 50Cent = 50
           ^
~~~~~~~~~~

그런데 이를 backquotes **`** 으로 선언을 하면 사용이 가능하다.
~~~~~~
scala> val `[]` = "Pararar"
[]: String = Pararar
~~~~~~
이렇게 사용할 필요는 없겠지...

# Numeric Types
Scala에서 제공하는 숫자형 타입은 아래와 같다. 단 C, Java와는 다르게 primitive type은
Type은 제공하지 않는다. 따라서 아래 링크의 숫자형 타입은 모두 class 이다.

[Core numeric types](https://www.google.co.kr/imgres?imgurl=http%3A%2F%2Fwww.topjavatutorial.com%2Fwp-content%2Fuploads%2F2016%2F07%2Fscala-numeric-types.png&imgrefurl=http%3A%2F%2Fwww.topjavatutorial.com%2Fscala%2Fscala-type-hierarchy%2F&docid=46wagrIpHZBXlM&tbnid=Swf7-aQ3IBM12M%3A&vet=10ahUKEwjc8rjquYPaAhUBvLwKHb1vAK0QMwg9KAEwAQ..i&w=514&h=301&safe=active&bih=930&biw=958&q=Core%20numeric%20types%20in%20scala&ved=0ahUKEwjc8rjquYPaAhUBvLwKHb1vAK0QMwg9KAEwAQ&iact=mrc&uact=8)

Scala에서는 하위 Rank의 숫자 타입을 상위 Rank의 숫자 타입으로 자동 변환이 가능하다.
다만 그 반대의 경우는 지원을 하지 않는다. 예를 들면 아래와 같다.

~~~~~~~~~
scala> var byte_num : Byte = 1
byte_num: Byte = 1

scala> var int_num : Int = byte_num
int_num: Int = 1

scala> int_num
res3: Int = 1

scala> var byte_num2 : Byte = int_num
<console>:12: error: type mismatch;
 found   : Int
 required: Byte
       var byte_num2 : Byte = int_num
                              ^
~~~~~~~~~
상기의 경우 처럼 Byte --> Int 로의 자동변환은 가능하나 Int 를 다시 Byte로 자동변환 할 수는 없다.
이는 위의 표에서 보았던 것 처럼 각 숫자형 타입의 경우는 서로 다른 범위를 가지고 있기에 상위 Rank
에서 하위 Rank로의 변환은 값의 손실을 발생 시 킬 수 있기 때문이다.
손실을 감안하고 상위 Rank의 숫자형 타입을 하위 Rank 타입으로 치환하기 위해서는 각 숫자형 Type class
에서 제공하는 method를 이용하면 된다. 아래는 Int를 Byte로 변환하기 위해 명시적으로 toByte method를
사용한 예이다.
~~~~~~~~~~~~
scala> int_num
res4: Int = 1

scala> var byte_num2 : Byte = int_num.toByte
byte_num2: Byte = 1

scala> byte_num2
res5: Byte = 1
~~~~~~~~~~~~

## Numeric literals
Numeric literals 숫자형을 나타내는 문자라는 말인가? 즉 C, Java에서 16진수를 표시하기
위해 사용하는 **0x** 것들을 지칭한다.

Literal | Type | Description
:--------:|:------:|:------------
5|Int| Default Int
0x|Int|'0x'Hexadecimal
5L or 5l|Long|'L' denote Long
5.0|Double|Default Double
5F or 5f|Float|'f' denote Float
5D or 5d|Double|'d' denote Double

# Strings
String에 대해 소개하는 것을 보면 일단 다른 언어 Java, Python 처럼 **""** 사이의
값은 String으로 인식하게 된다. **\(backslahs)**를 통해 특수 문자를 사용할 수도 있다.
~~~~~~~~~
scala> val hello = "Hello There"
hello: String = Hello There

scala> val greeting = "I gave you, \nhearty greeting."
greeting: String =
I gave you,
hearty greeting.
~~~~~~~~~

그런데 Java와는 다르게 **'=='** 을 통해, Python 에서와 같이, String 비교를 할 수가 있다.
~~~~~~~~
scala> hello == greeting
res6: Boolean = false
~~~~~~~~

또한 Python에서 지원을 하는 **"""** MultiLine 을 지원한다. 이 MultiLine 내에서는
특수 문자도 일반 문자처럼 인식을 한다.
~~~~~~
scala> val greeting2 =
  """Hearty Welcome? \n
     | Who can give you more hearty welcome than me. Haha.
  """

  greeting2: String =
  "Hearty Welcome? \n
   Who can give you more hearty welcome than me. Haha.
    "
~~~~~~

## String Interpolation
문자열 끼워 넣기라는 뜻 인데. 이 기능은 정말 좋은 것 같다.(그런데 끼워 넣기보다는
교체가 맞는 것 같다.)
~~~~~~~
scala> val pi = 3.14159
pi: Double = 3.14159

scala> val intro_pi : String = s"What the value of ${pi}"
intro_pi: String = What the value of 3.14159
~~~~~~~

위의 코드를 보면 **s** 와 **$** 그리고 **{}** 로 문자열 내에 이미 선언되어
있는 상수를 대입하여 사용하고 있다.
자바라면 print 문 내에서
~~~~~~~
double pi = 3.14159;
System.out.println("What the value of " + pi);
~~~~~~~
와 같이 처리를 해주어야 할 것인데 위의 예제에서 만약 문자열에 끼워 넣어야 할 상수
, 변수등의 값이 많아 질 경우 이르 처리하는 코드를 작성 할 때 약간 귀찮은 일이
많이 발생을 하는데 단순히 scala에서는 **s,$,{}**로 끼워 넣기가 구현되니 말이다.

**{}** 의 경우는 꼭 사용할 필요는 없으나 명시적으로 문자열 내에서 치환될 부분을
선언해 줄 때 사용하게 된다.
그런데 이 String Interpolation 에서 Python의 향기가 느껴졌다. 바로 아래를 보면
문자열을 몇 번 끼워 넣을 것인 지를 지정하여 표시 할 수 있다.
~~~~~~~
scala> val item = "Apple-Pie "
item: String = "Apple-Pie "

scala> s"I like ${item * 3}."
res2: String = I like Apple-Pie Apple-Pie Apple-Pie .
~~~~~~~

**f"..."** 아래의 예시에서 **f**는 위의 **s**를 사용하는 것 처럼 미 사용된 변수,상수
값을 문자열 내에 가져다 사용할 수 있게 하는데 보다시피 해당 변수 등이 가지고 있는
값의 일부만 출력을 한다든지 하는 값을 변형 시킬 수 있게된다.
~~~~~~~
scala>val item = "apple"
res4: String = apple
scala> f"I wrote a new $item%.3s today"
res5: String = I wrote a new app today

scala> f"The Value of Pi = ${355/113.0}%.5f"
res5: String = The Value of Pi = 3.14159
~~~~~~~

문자열 내에 미리 선언된 변수를 가져와 특정 형식으로 치환을 할 때 **s"**
와 같은 형식을 사용하면 아래의 예시처럼 원하는 결과를 얻을 수가 없다.
~~~~~~
scala> item
res4: String = apple
scala> s"I like $item%.3f"
res6: String = I like apple%.3f
~~~~~~

# Regular Expression

~~~~~~
scala> val input = f"Enjoying this apple ${355/113.0}%.5f times today"
input: String = Enjoying this apple 3.14159 times today

scala> val pattern = """.* apple ([\d.]+) times .*""".r
pattern: scala.util.matching.Regex = .* apple ([\d.]+) times .*

scala> val pattern(amountText) = input
amountText: String = 3.14159

scala> val amount = amountText.toDouble
amount: Double = 3.14159
~~~~~~

Scala 에서 **"""** 를 통해 escaping backslash 없이 문자열 내에서 특수 문자를
사용할 수 있다는 말을 들었을 때 가장 먼저 든 생각은 Python의 reqular expression
이었다. Python의 reqular expression에서는, 내 기억이 맞는 다면 re"..." 와 같은
형식으로 Reqular Expression pattern 을 선언 하며 해당 pattern의 문자열 내에서는
escaping backslash를 사용하지 않아도 된다.

Escaping BackSlash 란? Java에서 문자열 내에 특수문자를 넣고 이를 출력 하고 싶을 떄
, 가령 linefeed를 넣을 떄 **\n** 와 같이 넣는데 이렇게 하면 화면에서는 줄바꿈이 일어
나고 **\n**은 출력이 되지 않는다. 이 때 **\\n** 와 같이 표현을 해 주면 해당 특수문자
는 일반 문자처럼 인식이 되어 화면에 출력되게 된다.

**"""** 내에서 escaping backslash를 특수문자에서 사용하지 않아도 된다면 Reqular
Expression을 사용하기가 매우 편리해 진다.

위의 예시에서는 문자열 내에서 Double 형의 숫자를 찾아 추출하는 예시를 보여 준다.

# Core Nonnumeric Types
[Core Types hierarchy](https://www.safaribooksonline.com/library/view/learning-scala/9781449368814/images/lnsc_0201.png.jpg)

Name | Description | Instantiable
:-------:|:---------|:---------:
Any | The root of all types in scala | No
Anyval | The root of all value types | No
AnyRef | The root of all reference(nonvalue) types | No
Nothing | The subclass of all types | No
Null | The subclass of all AnyRef types signifying a null value | No
Char | Unicode Character | Yes
Boolean | true or false | Yes
String | A string of characters(i.e., text) | Yes
Unit | Denotes the lack of a value | No

## Any
Any Type은 모든 Type의 부모 Type 이며, AnyVal, AnyRef을 자식 Type으로 가지고 있다.
## AnyVal
AnyVal 을 확장하여 사용되는 Type 들은 모든 data의 근간을 이루는 value type이다.
즉, Int,Byte,Long 과 같은 Numeric Type 부터 Char, Boolean, Unit들이 이들이다.
AnyVal을 확장하여 사용하는 Type 들은 heap 에서는 Object로 그리고 stack memory 상에서는
primitive(JVM) 으로 존재하게 된다.
## AnyRef
AnyRef 을 root type으로 사용하는 모든 type들은 heap memory 상에 object로 존재하게
된다. **Ref** 에서 유추할 수 있듯이 AnyRef를 root type로 가지는 type 들은
Reference Type들을 의미하며 이는 Memory reference로 각 type의 값에 접근을 하게 된다.
## Nothing
Nothing 은 다른 모든 type의 하위 타입이며, 이는 호환성을 위해 존재해야하는 중용한
 type 이라고 한다. 예를 들어 함수가 return 값을 생성하는 도중에(?)
return을 하게 될 때, 이 return 값이 가지게 되는 type이 된다. (정확하게 어떤 경우인지
모르겠으나.. 아마 lazy function이나 비동기 처리로 인해 함수가 바로 return을 하게 될 때
return value가 가지는 type을 말하는 것 같다.)
## Null
Null 은 AnyRef을 부모 type으로 가지는 모든 type의 하위 type이며, 이는 null을 표현하기
위해 존재한다.
## Char
Char는 C, Java등 에서와 같이 String(문자열)을 이루는 최소 type이며, Numeric Data Types
에서 발견되는 type이다. 이게 무슨 말이냐 하면 ASCII 이야기이다. Char의 경우는 1byte를
의미하며, 1byte는 하나의 문자를 의미하는데 이 하나의 문자는 ASCII 상에서는 10진수 중 하나를
의미한다는 것이다. 아래의 예를 보자
~~~~~~~~
scala> val c= 'A'
c: Char = A
scala> val i: Int = c
i: Int = 65
scala> val t: Char = 116
t: Char = t
~~~~~~~~
Char type은 숫자 type인 Int c로 convert가 가능하며, convert 되었을 때 ASCII 상의 값으로 표현이 된다는
것이다.
## Boolean
true, false 를 표현하기 위해 존재하는 type. 여기서 한가지 알아 두어야 할 것은 Boolean과 연관된 사항 중
다른 언어와 차이점이 발견된다. C 의 경우는 0 은 if 와 사용되게 되면 false를 의미하고, 1은 true를 의미한다.
그런데 Scala는 이를 지원하지 않는다.
~~~~~~~~
int zero = 0;
if (!zero) {
   print(zero is false);
   zero = 1;
}

if (zero) {
  print(zero is true)
}
~~~~~~~~

바로 위와 같이 1,0,null, 변수에 value가 존재/비존재 시에 이를 true, false로 사용하지 못한다는
것이다.
## Unit
Unit은 function에서 보았던 것 처럼, return 값이 없음을 나타내는 type이다. 마치 C, Java에서의 **void**와 같다.
아래의 예시처럼 상수 또는 변수가 Unit type을 가지게 할 수는 있으나, 아래와 같은 방식은 보편적으로 사용되지 않는다.
~~~~~~~
scala> var nothing = ()
nothing: Unit = ()

scala> val nothing1 = ()
nothing1: Unit = ()
~~~~~~~
## Type Operations
아래의 각 함수들은 각 type들이 모두 가지고 있는 함수들이며 해당 부분에 대해 하나씩 살펴 보자.
- asInstanceOf[<type>] : type을 다른 type으로 변경을 하는 함수이다. 그런데 Numeric value를
가지는 변수가 Boolean으로 변경이 될 수 없는 것 처럼 제약사항이 많으니 이 함수를 사용하는 것은 자제 해야겠다.
~~~~~
scala> val zero = 0
zero: Int = 0

scala> zero.asInstanceOf[Boolean]
java.lang.ClassCastException: java.base/java.lang.Integer cannot be cast to java.base/java.lang.Boolean
  at scala.runtime.BoxesRunTime.unboxToBoolean(BoxesRunTime.java:85)
  ... 24 elided

scala> zero.asInstanceOf[Long]
res4: Long = 0
~~~~~
- getClass : 변수/상수의 type을 가져오는 함수이다.
~~~~~
scala>
zero.getClass
res5: Class[Int] = int
~~~~~
- isInstanceOf : 변수/상수의 type이 명시한 type에 속하는지 질의하는 함수
~~~~~
scala> zero.isInstanceOf[Int]
res6: Boolean = true
~~~~~
- hashCode : 변수/상수의 hashCode를 가져오는 함수
~~~~
scala> zero.hashCode()
res7: Int = 0
scala> "A".hashCode
res8: Int = 65
~~~~
-  to<type> : asInstanceOf와 같은 목적을 가지는 함수. 각 type에는 변환가능한 type에
대한 함수만을 제공하므로 asInstanceOf와 같은 호환성에러가 나오지 않는다. 예를 들어
Int에서는 **toBoolean** 과 같은 함수는 제공되지 않는다.
~~~~
scala> zero.toOctalString
res9: String = 0
scala> zero.toByte
res10: Byte = 0
~~~~
- toString : 변수/상수의 값을 String으로 변환하는 함수
~~~~
scala> zero.toString
res12: String = 0
~~~~
## Tuples
Scala에서의 tuple은 서로 다른 type의 값들을 보관 할 수 있는 보관소(Container)역활을 한다.
Arrays 또는 List의 경우와 같이 iteration 동작을 통한 각 값에 대한 접근을 허용하지 않는다.
Tuple 생성시에는 아래와 같은 방식으로 **()** 안에 **,** 로 구분한 값을 넣어서 선언을 한다.
~~~~~
scala> (10, 11, 3.134, "scala-newbie")
res0: (Int, Int, Double, String) = (10,11,3.134,scala-newbie)
scala> var info = (10,11,3.134,"scala-newbie")
info: (Int, Int, Double, String) = (10,11,3.134,scala-newbie)
~~~~~

만약 Tuple 내의 값에 접근하고 싶다면 **._<index>** 와 같은 형식으로 값에 접근 가능하다.
~~~~
scala> info._1
res1: Int = 10
scala> info._4
res2: String = scala-newbie
~~~~

또한 2개의 항목으로 구성된 Tuple을 만들고 싶다면 아래와 같은 형식으로도 가능하다.
~~~~
scala> var tuple2 = "read" -> "or"
tuple2: (String, String) = (read,or)
~~~~

기존에 만들어진 tuple을 포함하는 새로운 tuple을 만드는 것도 아래와 같이 가능하다.
~~~~
scala> tuple2.->("die")
res7: ((String, String), String) = ((read,or),die)
scala> info.->("new tuple", 9, 33)
res6: ((Int, Int, Double, String), (String, Int, Int)) = ((10,11,3.134,scala-newbie),(new tuple,9,33))
~~~~


