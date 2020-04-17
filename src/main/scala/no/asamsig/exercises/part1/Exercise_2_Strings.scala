package no.asamsig.exercises.part1

/**
 *
 * Scala Workshop Exercise 2
 *
 */
object Exercise_2_Strings {

  /**
   * 1. StringFormat.
   *
   * Use string interpolation s"$var" to format [name] and [value] as "name=value"
   */
  def stringFormat(name: String, value: Number): String = {
    ???
  }

  /**
   * 2. Split string
   *
   * Take the input in the form "Lastname, Firstname, age" and return
   * the a string formatted as "FL: Age"
   * where F and L are uppercase initials
   *
   * Useful functions:
   * [Char.toUpper]
   * [String.head]
   * [String.split]
   *
   */
  def splitString(input: String): String = {
    ???
  }

  /**
   * 3. Palindrome
   *
   * Decide if the given string is a palindrome (reads the same forward and backwards).
   *
   * [String.reversed] can be useful
   *
   */
  def isPalindrome(s: String): Boolean = {
    ???
  }

  /**
   * 4. Json Format
   *
   * Use the function [[List.mkString]] on the input [list] to return the comma separated list inside brackets.
   * i.e. 1, 2, 3 => "[1, 2, 3]"
   *
   */
  def jsonFormat(list: List[Int]): String = {
    ???
  }

  /**
   * 5. Multiline String
   *
   * Format as JSON using multiline String and String interpolation
   * """
   * = {
   * "title": "Captain Marvel",
   * "year": 2019,
   * ...
   * }
   * """
   **/
  def movieToJson(title: String, year: Int, runtime: Int, rating: String = "PG-12", country: String = "USA"): String = {
    ???
  }

  /**
   * 6. Acronym
   *
   * Return the Acronym of the supplied title.
   *
   * Example: "application programming interface" => "API"
   *
   */
  def acronym(title: String): String = {
    ???
  }
}