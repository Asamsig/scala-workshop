package no.asamsig.exercises.part1

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class Exercise_2_StringsTest extends AnyFreeSpec with Matchers {

  "1. stringFormat Test" in {
    Exercise_2_Strings.stringFormat("Answer", 42) shouldBe "Answer=42"
  }

  "2. splitString Test" in {
    Exercise_2_Strings.splitString("little, kim, 28") shouldBe "KL: 28"
  }

  "3. palindrome Test" in {
    Exercise_2_Strings.isPalindrome("palindrome") shouldBe false
    Exercise_2_Strings.isPalindrome("racecar") shouldBe true
  }

  "4. jsonFormat should format the input as a json list" in {
    Exercise_2_Strings.jsonFormat(List(1, 2, 3, 4)) shouldBe "[1, 2, 3, 4]"
    Exercise_2_Strings.jsonFormat(List.empty) shouldBe "[]"
    Exercise_2_Strings.jsonFormat(List(1)) shouldBe "[1]"
  }

  "5. movieToJson Test" in {
    val strippedJson = Exercise_2_Strings.movieToJson("Avengers: Endgame", 2019, 181).filterNot(_.isWhitespace)
    strippedJson shouldBe """{"title":"Avengers:Endgame","year":2019,"runtime":181,"rating":"PG-12","country":"USA"}"""
  }

  "6. acronym Test" in {
    Exercise_2_Strings.acronym("application programming interface") shouldBe "API"
    Exercise_2_Strings.acronym("gnu's not unix") shouldBe "GNU"
  }

}