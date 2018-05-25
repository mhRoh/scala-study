# while && do while
- For Loop 다른 점이 몇가지가 존재, while 내에서 수행한는 것들은 statement, 고로 yield를 사용할 수 없다.
~~~~~
while (<Boolean expression>) statement

var x=10
while (x > 0) x -= 1
~~~~~
do while의 경우는 다른 언어에서와 마찬가지로 먼저 loop 안의 statement가 수행이 되고 후에 loop 반복 조건을 검사하는 방식으로
진행이 된다. 
~~~~~
do statement while (<Boolean expresion>)

var x = 0
do println(s"Now you see me, x = $x") while (x > 0)
~~~~~




