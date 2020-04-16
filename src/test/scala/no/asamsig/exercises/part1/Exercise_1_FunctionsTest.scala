package no.asamsig.exercises.part1

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class Exercise_1_FunctionsTest extends AnyFreeSpec with Matchers {

  "1. the function 'helloWorld' should return 'Hello World!'" in {
    Exercise_1_Functions.helloWorld should equal("Hello World!")
  }

  "2. assignment() should return 25" in {
    Exercise_1_Functions.assignment() shouldBe 25
  }

  "3. use val instead of var" in {
    fail("Remove this line when you have finished the exercise")
    Exercise_1_Functions.varAndVal("Korg", "Miek") shouldEqual ("Korg and Miek")
  }

  "4. square(n) should return n*n" in {
    Exercise_1_Functions.square(2) shouldBe 4
    Exercise_1_Functions.square(5) shouldBe 25
    Exercise_1_Functions.square(10) shouldBe 100
  }

  "5. max(n, m) should return the highest of n and m" in {
    Exercise_1_Functions.max(1, 2) shouldBe 2
    Exercise_1_Functions.max(2, 1) shouldBe 2
    Exercise_1_Functions.max(3, 3) shouldBe 3
    Exercise_1_Functions.max(-1, -2) shouldBe -1
  }

  "6. maxOf3(n, m, i) should return the highest of n, m and i" in {
    Exercise_1_Functions.maxOf3(4, 1, 2) shouldBe 4
    Exercise_1_Functions.maxOf3(-1, 3, 1) shouldBe 3
    Exercise_1_Functions.maxOf3(3, 3, 3) shouldBe 3
    Exercise_1_Functions.maxOf3(-1, -2, 0) shouldBe 0
  }

  "7. abs should return the absolute value" in {
    Exercise_1_Functions.abs(10.2) shouldBe 10.2
    Exercise_1_Functions.abs(-5.0) shouldBe 5.0
  }

  "8. isLeapYear" in {
    Exercise_1_Functions.isLeapYear(2019) shouldBe false
    Exercise_1_Functions.isLeapYear(2020) shouldBe true
    Exercise_1_Functions.isLeapYear(1700) shouldBe false
    Exercise_1_Functions.isLeapYear(1600) shouldBe true
    Exercise_1_Functions.isLeapYear(1972) shouldBe true
    Exercise_1_Functions.isLeapYear(1900) shouldBe false
  }

  "9. paceCalculator" in {
    Exercise_1_Functions.pace(10000, 60, 0) shouldBe(6, 0)
    Exercise_1_Functions.pace(5000, 25, 0) shouldBe(5, 0)
    Exercise_1_Functions.pace(3000, 20, 30) shouldBe(6, 50)
  }

}