package no.asamsig.exercises.part1

/**
 *
 * Scala Workshop Exercise 1
 *
 */
object Exercise_1_Functions {

  /**
   * 1. Hello World.
   *
   * Make the function [helloWorld] the [String] "Hello World!"
   */
  def helloWorld: String = ???

  /**
   * 2. Assignment.
   *
   * Assign a value to [a] such that the function returns 25"
   *
   */
  def assignment(): Int = {
    val a: Int = ???
    val b = 5
    a * b
  }

  /**
   * 3. Var and Val
   *
   * Rewrite the function to use [val] instead of [var]
   * (this exercise cannot be verified by the test code, so simply
   * remove the call to fail("...") from the corresponding test when you're done)
   */
  def varAndVal(a: String, b: String): String = {
    var name: String = a.capitalize
    name += " and "
    name += b.capitalize
    name
  }

  /**
   * 4. Square
   *
   * the square of the input [n]
   */
  def square(n: Int): Int = ???

  /**
   * 5. Max.
   *
   * Make this function the highest number of [n] or [m]
   */
  def max(n: Int, m: Int): Int = {
    ???
  }

  /**
   * 6. Max of 3.
   *
   * Make this function the highest number of [n], [m] and [i]
   */
  def maxOf3(n: Int, m: Int, i: Int): Int = {
    ???
  }

  /**
   * 7. Absolute value
   *
   * Implement a function to the absolute value of the input
   * (without using the built in [Double.absoluteValue])
   */
  def abs(value: Double): Double = {
    ???
  }

  // EXTRA if you've got time in the end, come back and solve these

  /**
   * 8. Leap Year
   *
   * Decide if the given year is a leap year.
   *
   * Every year that is exactly divisible by four is a leap year,
   * except for years that are exactly divisible by 100,
   * but these centurial years *are* leap years if they are exactly divisible by 400.
   *
   * The function [Int.rem] will be usefull
   *
   */
  def isLeapYear(year: Int): Boolean = {
    ???
  }


  /**
   * 9. Pace caclculator
   *
   * Given a distance in meters, and the time it took to run it in minutes and seconds,
   * calculate the pace (as minutes and seconds per km)
   *
   * use `Pair(minutes, seconds)` to two values
   *
   *
   */
  def pace(distance: Int, minutes: Int, seconds: Int): (Int, Int) = {
    ???
  }

}