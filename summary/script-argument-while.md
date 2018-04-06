# Scala Script
 Scala 의 경우 큰 규모의 System 개발에도 사용되지만 Python 처럼 Script
모드로 활용이 가능한 언어이다. Scala script를 실행하기 위해서는 아래와
같이 실행하면 된다.

~~~~~~~~
$ scala first-script.scala
~~~~~~~~

그런데 나는 IntelliJ의 scala plugin에서 공부를 진행하고 있으니 위 처럼 할
수는 없고... IntelliJ에서 실행하는 것으로 대신을 하였다.
## Arguments - Index
first-script.scala에 보면 아래와 같은 코드가 있다. 음.. args 하면 떠오르는
것은 programme argument 이다. args로 실행시 넘어오는 User Input에
접근을 하게 되어 있구나. Java와 비교를 해 보았을 때 좀 다른 면이 있다.
Java에서는 **[ ]** 즉 array로 인자가 넘어와 각 argument에 접근을 하게 되었는데
여기에서는 **( )** 을 사용한다. 뭐 이건 언어 개발자가 그렇게 정한 것이니
그렇게 알고 넘어가자.(그런데 왜 **()** 로 한 것일까? 일관성? Functional
언어를 지향하는 scala이며 대부분의 함수로 구현되어 있다고 불리우는 언어이다
보니 이 부분도 그렇게 처리한 것일까?)
~~~~~~~
println("............. : " + args(0))
~~~~~~~

그런데 이상한 것이 있네 **args(0)** 의 내용을 가져오면 Java에서는 실행 대상
파일 명이 들어가있는데 여기서는 다른가? IntelliJ에 run&debug 부분에 수정을 하여
programme argument로 *ScriptArg*를 넣어서 실행해 보았다. 그랬더니 아래와 같이
결과가 출력이 되었다.
~~~~~~~
Hello, world, from a script! : ScriptArg
~~~~~~~
Java와는 다르게 arguments array의 첫번째 인자로 넘어오는 값은 실행파일명이 아닌
user 입력이 넘어오는 것을 확인 할 수 있었다.
또 Java와 비교를 하였을 때 Scala의 경우는 main 진입점이 존재하지 않는 것이 차이점
이다. 이는 같은 Script 모드로 실행이 가능한 Python 과도 다른 점이다.
(Python은 if __name__ == "main":  으로 첫번째 진입점을 명시하게 된다.)
