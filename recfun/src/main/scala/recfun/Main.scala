package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    * The numbers at the edge of the triangle are all 1,
    * and each number inside the triangle is the sum of the two numbers above it.
    * Write a function that computes the elements of Pascal’s triangle by means of a recursive process.
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }
  
  /**
   * Exercise 2
    * Write a recursive function which verifies the balancing of parentheses in a string,
    * which we represent as a List[Char] not a String
   */
    def balance(chars: List[Char]): Boolean = {
      def bSolver(left:Int, chars:List[Char]):Boolean = {
        if (chars.isEmpty)
          left == 0
        else if (left < 0)
          false
        else if (chars.head == '(')
          bSolver(left + 1, chars.tail)
        else if (chars.head == ')')
          bSolver(left - 1, chars.tail)
        else
          bSolver(left, chars.tail)
      }
      bSolver(0, chars)
    }
  
  /**
   * Exercise 3
    * Write a recursive function that counts how many different ways you can make change for an amount,
    * given a list of coin denominations.
    * For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def countSolver(money: Int, coins: List[Int]): Int = {
        if (money < 0 || coins.isEmpty) 0
        else if (money == 0 ) 1
        else countSolver(money, coins.tail) + countSolver(money-coins.head, coins)

      }
      countSolver(money, coins)
    }
  }
