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

## Strings
String에 대해 소개하는 것을 보면 일단 다른 언어 Java, Python 처럼 **"** 사이의
값은 String으로 인식하게 된다. **\(backslahs)**를 통해 특수 문자를 사용할 수도 있다.
~~~~~~~~~
scala> val hello = "Hello There"
hello: String = Hello There

scala> val greeting = "I gave you, \nhearty greeting."
greeting: String =
I gave you,
hearty greeting.
~~~~~~~~~

그런데 Java와는 다르게 **'=='** 을 통해, Python 에서와 같이, Sting 비교를 할 수가 있다.
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

### String Interpolation
문자열 끼워 넣기라는 뜻 인데. 이 기능은 정말 좋은 것 같다.
~~~~~~~
scala> val pi = 3.14159
pi: Double = 3.14159

scala> val intro_pi : String = s"What the value of ${pi}"
intro_pi: String = What the value of 3.14159
~~~~~~~

위의 코드를 보면 **s** 와 **$** 그리고 **{}** 로 문자열 내에 이미 선언되어
사용되고 있는 상수를 대입하여 사용하고 있다.
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
