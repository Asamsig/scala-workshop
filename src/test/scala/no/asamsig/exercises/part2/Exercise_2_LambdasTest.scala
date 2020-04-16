package no.asamsig.exercises.part2

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class Exercise_2_LambdasTest extends AnyFreeSpec with Matchers {

  "1. Filter" in {
    Exercise_2_Lambdas.filterUpperCase("") shouldBe ""
    Exercise_2_Lambdas.filterUpperCase("FooBar") shouldBe "FB"
    Exercise_2_Lambdas.filterUpperCase("Foo Bar") shouldBe "F B"
    Exercise_2_Lambdas.filterUpperCase("FOO BAR") shouldBe "FOO BAR"
    Exercise_2_Lambdas.filterUpperCase("abcde") shouldBe ""
  }

  "2. Count Letters" in {
    Exercise_2_Lambdas.letterCount("", 'a') shouldBe 0
    Exercise_2_Lambdas.letterCount("abc", 'b') shouldBe 1
    Exercise_2_Lambdas.letterCount("xyzzy", 'z') shouldBe 2
  }

  "3. One or Zero" in {
    Exercise_2_Lambdas.oneOrZero(10, _ => true) shouldBe 1
    Exercise_2_Lambdas.oneOrZero(10, _ => false) shouldBe 0
    Exercise_2_Lambdas.oneOrZero(5, _ % 2 == 1) shouldBe 1
    Exercise_2_Lambdas.oneOrZero(5, _ % 2 == 0) shouldBe 0
    Exercise_2_Lambdas.oneOrZero(4, _ % 2 == 0) shouldBe 1
    Exercise_2_Lambdas.oneOrZero(4, _ % 2 == 1) shouldBe 0
  }

  "4. Operation" in {
    Exercise_2_Lambdas.intOperation(4, 2, _ + _) shouldBe 6
    Exercise_2_Lambdas.intOperation(10, 5, _ / _) shouldBe 2
  }

  "5. Return Lambda" in {
    Exercise_2_Lambdas.surroundString("[", "]")("foo") shouldBe "[foo]"
    Exercise_2_Lambdas.surroundString("", "")("bar") shouldBe "bar"
    Exercise_2_Lambdas.surroundString("<", ">")("") shouldBe "<>"
  }

}