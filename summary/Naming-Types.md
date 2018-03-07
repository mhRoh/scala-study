# Naming
변수, 상수 명을 Scala에서 어떻게 사용하는 가에 대한 내용이다.
다른 언어의 경우는 변수/상수명을 사용하는 것에 많은 제약이 있는 편이다. 그런데
이 Scala의 경우는 많은 금지된 것들이 가능하다. 심지어는 아래와 같은 것도 가능하다.

~~~~~~~~~
scala> val * = 3.3
*: Double = 3.3
~~~~~~~~~

이건 너무 파격적이지 않은가? 이러한 특성 때문에 코드 가독성을 높을 수 있게
작성 할 수 있다고 한다. 일단 변수명으로 사용가능한 것을 보면
문자, 숫자 그리고 special operator character 라고 한다. 여기 Special operator
character의 범위는 Unicode로 따진다면 \u0020 ~ \u007F, 그리고  **[] .** 을 제외한
Unicode Symbol 과 수학 기호까지 포함을 한다.

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

# Types





