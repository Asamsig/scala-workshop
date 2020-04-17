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
   * Make the function [[helloWorld]] return the [[String]] "Hello World!"
   */
  def helloWorld: String = "Hello World!"

  /**
   * 2. Assignment.
   *
   * Assign a value to [a] such that the function returns 25"
   *
   */
  def assignment(): Int = {
    val a: Int = 5
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
    val nameA: String = a.capitalize
    val and = " and "
    val nameB = b.capitalize
    nameA + and + nameB
  }

  /**
   * 4. Square
   *
   * Return the square of the input [n]
   */
  def square(n: Int): Int = n * n

  /**
   * 5. Max.
   *
   * Make this function return the highest number of [n] or [m]
   */
  def max(n: Int, m: Int): Int = {
    Math.max(n, m)
  }

  /**
   * 6. Max of 3.
   *
   * Make this function return the highest number of [n], [m] and [i]
   */
  def maxOf3(n: Int, m: Int, i: Int): Int = {
    List(n, m, i).max
  }

  /**
   * 7. Absolute value
   *
   * Implement a function to the absolute value of the input
   */
  def abs(value: Double): Double = {
    value.abs
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
   * The function [[Int.%]] will be useful
   *
   */
  def isLeapYear(year: Int): Boolean = {
    (year % 4, year % 100, year % 400) match {
      case (_, _, 0) => true
      case (_, 0, _) => false
      case (0, _, _) => true
      case _         => false
    }
  }


  /**
   * 9. Pace calculator
   *
   * Given a distance in meters, and the time it took to run it in minutes and seconds,
   * calculate the pace (as minutes and seconds per km)
   *
   * use `(minutes, seconds)` return to two values
   *
   *
   */
  def pace(distance: Int, minutes: Int, seconds: Int): (Int, Int) = {
    val km = distance / 1000.0
    val minPerKm: Int = (minutes / km).toInt
    val secLefts = ((minutes / km) - minPerKm) * 60
    val secPerKm = seconds / km
    (minPerKm, secLefts.toInt + secPerKm.toInt)
  }

}