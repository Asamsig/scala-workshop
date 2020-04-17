package no.asamsig.exercises.part1

import no.asamsig.service.petstore.{PetId, PetStoreService}

/**
 *
 * Scala Workshop Exercise 3
 *
 */
object Exercise_3_Types {

  /**
   * 1. Absence of a value
   *
   * Return a multiline string with the parameter names and values. Parameter names
   * should be uppercase, values should be capitalized, and missing values should be represented by "NA"
   *
   * example:
   * FIRSTNAME: Lea
   * MIDDLENAME: NA
   * LASTNAME: Williamson
   * OCCUPATION: Footballer
   *
   */
  def absenceOfAValue(firstName: String, middleName: Option[String], lastName: String, occupation: Option[String]): String = {
    s"""|FIRSTNAME: ${firstName.capitalize}
        |MIDDLENAME: ${middleName.map(_.capitalize).getOrElse("NA")}
        |LASTNAME: ${lastName.capitalize}
        |OCCUPATION: ${occupation.map(_.capitalize).getOrElse("NA")}""".stripMargin
  }

  /**
   * 2. Nested missing values
   *
   * Given the supplied petStoreService and petId, fix the commented out code (it won't compile as it is)
   * (use "NA" as replacement for missing values)
   */
  def findPetAndCategoryName(petStoreService: PetStoreService, petId: PetId): (String, String) = {
    val pet = petStoreService.findById(petId)
    (pet.map(_.name).getOrElse("NA"), pet.flatMap(_.category.map(_.name)).getOrElse("NA"))
  }

  /**
   * 3. Pattern matching
   *
   * This function should decide what type the input is, and return
   * in the format: "input: Type" if it is an Int or a Double
   * If it is a String, input should be wrapped in quotes, e.g. "\"input\": String"
   * For any other type return "I don't know what that was"
   */
  def mysteryInput(input: Any): String = {
    input match {
      case input: String => s""""$input": String"""
      case input: Int => s"$input: Int"
      case input: Double => s"$input: Double"
      case _ => "I don't know what that was"
    }
  }

  /**
   * 4. Pattern matching with missing values
   *
   * This function should decide what type the input is, and return
   * the first character if it is a String
   * the value / 2 if it's an even Int
   * 1 if it's an odd Int
   * 0 if it's a Double greater or equal to 0
   * -1 if it's a Double less than 0
   * None for all other input
   *
   */
  def mysteryInputOption(input: Option[Any]): Option[Any] = {
    input.flatMap {
      case input: String if input.nonEmpty => Some(input.head)
      case input: Int if input % 2 == 0 => Some(input / 2)
      case _: Int => Some(1)
      case input: Double if input >= 0 => Some(0)
      case _: Double => Some(-1)
      case _ => None
    }
  }
}