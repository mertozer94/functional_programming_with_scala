# functional_programming_with_scala

## Some notes about functional programming and scala

/* call-by-value means the parameters are evaluated left to 
** right to determine their value before the function itself 
** is evaluated 
*/
def first(a: Int, b: Int): Int = a
first(3 + 4, 5 + 6) // will be reduced to first(7, 5 + 6), then first(7, 11), and then 7

/* call-by-name means the paramter is passed into the function 
** as is. Parameter evaluation takes place after 
** substitution 
*/
def first1(a: Int, b: => Int): Int = a
first1(3 + 4, 5 + 6) // will be reduced to (3 + 4) and then to 7



With def you can get new function on every call:

val test: () => Int = {
  val r = util.Random.nextInt
  () => r
}

test()
// Int = -1049057402
test()
// Int = -1049057402 - same result

def test: () => Int = {
  val r = util.Random.nextInt
  () => r
}

test()
// Int = -240885810
test()
// Int = -1002157461 - new result


val evaluates when defined, def - when called:

scala> val even: Int => Boolean = ???
scala.NotImplementedError: an implementation is missing

scala> def even: Int => Boolean = ???
even: Int => Boolean

scala> even
scala.NotImplementedError: an implementation is missing


tail recursion in scala 
@tailrec

you don't need the current stack frame any more. (Python does not have AFAIK tail-recursion elimination)
