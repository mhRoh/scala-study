## 1-1. Print a string without using println
상기의 문제를 풀기위해서 인터넷을 뒤져 보았는데 Console, 및 System module
에는 입출력에 관한 method들을 제공하고 있었다. 아래는 Console 과 System을
이용하여 화면에 String을 출력한 여러 예제이다.
- Console module에서 printf 사용하기.
~~~~~~~~~
scala> Console.printf("hello%s", " World!")
hello World!
~~~~~~~~~
- Console 모듈의 out(PrintStream)을 통해 출력하기
~~~~~~~~~
scala> Console.out.append("Abcdefg").flush()
Abcdefg
~~~~~~~~~
- System 모듈의 setOut 함수에 PrintStream을 넘겨 출력하기
~~~~~~~~~
scala> System.setOut(Console.out.append("Cold Case"))
Cold Case
~~~~~~~~~
그런데 이게 이 문제의 답이 될 수 있나?
## 1-2. What Kinds of numbers, strings and other data does the REPL support?
조사 필요.
## 2. Convert 22.5 Centigrade to Fahrenheit using formula cToF(x)=(x*9/5)+32.
~~~~~~~~~~~~~
scala> def cToF(x:Double):Double = (x*9/5)+32
cToF: (x: Double)Double

scala> cToF(22.5)
res19: Double = 72.5
~~~~~~~~~~~~~