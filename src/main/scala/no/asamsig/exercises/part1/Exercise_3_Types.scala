package no.asamsig.exercises.part1

import no.asamsig.service.petstore.{PetId, PetStoreService}

/**
 *
 * Scala Workshop Exercise 3
 *
 */
object Exercise_3_Types {

  /**
   * 1. Nullabillity
   *
   * Return a multiline string with the parameter names and values. Parameter names
   * should be uppercase, values should be capitalized, and null values should be represented by "NA"
   *
   * example:
   * FIRSTNAME: Lea
   * MIDDLENAME: NA
   * LASTNAME: Williamson
   * OCCUPATION: Footballer
   *
   */
  def nullable(firstName: String, middleName: Option[String], lastName: String, occupation: Option[String]): String = {
    ???
  }

  /**
   * 2. Nullabillity and Elvis
   *
   * Given the supplied petStoreService and petId, fix the commented out code (it won't compile as it is)
   * (use "NA" as replacement for null values)
   */
  def findPetAndCategoryName(petStoreService: PetStoreService, petId: PetId): (String, String) = {
    val pet = petStoreService.findById(petId)
    // (pet.name, pet.category.name)
    ???
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
    ???
  }

  /**
   * 4. Pattern matching with Option
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
    ???
  }
}