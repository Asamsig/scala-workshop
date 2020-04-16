package no.asamsig.exercises.part1

import java.time.Instant

import no.asamsig.service.petstore.{Category, Pet, PetStoreService}
import org.mockito.scalatest.MockitoSugar
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class Exercise_3_TypesTest extends AnyFreeSpec with Matchers with MockitoSugar {

  "1. nullabillity Test" in {
    Exercise_3_Types.nullable("Lea", Option.empty, "Williamson", Option("footballer")) shouldBe
      """|FIRSTNAME: Lea
         |MIDDLENAME: NA
         |LASTNAME: Williamson
         |OCCUPATION: Footballer""".stripMargin
  }

  "2. petStoreTest" in {
    val petStoreService = mock[PetStoreService]
    val categoryDog = new Category {
      override val id = 4242L
      override val name = "Dog"
    }
    val pet = new Pet {
      override val id = 1010L
      override val name = "Rufus"
      override val category = Option(categoryDog)
      override val tags = Option.empty
    }
    when(petStoreService.findById(1010L)).thenReturn(Option(pet))
    Exercise_3_Types.findPetAndCategoryName(petStoreService, 1010L) shouldBe("Rufus", "Dog")
  }

  "3. mystery input test" in {
    Exercise_3_Types.mysteryInput("Arsenal") shouldBe "\"Arsenal\": String"
    Exercise_3_Types.mysteryInput(100) shouldBe "100: Int"
    Exercise_3_Types.mysteryInput(3) shouldBe "3: Int"
    Exercise_3_Types.mysteryInput(3.14) shouldBe "3.14: Double"
    Exercise_3_Types.mysteryInput(-1.0) shouldBe "-1.0: Double"
    Exercise_3_Types.mysteryInput(null) shouldBe "I don't know what that was"
    Exercise_3_Types.mysteryInput(new Object()) shouldBe "I don't know what that was"
  }

  "4. mystery input option test" in {
    Exercise_3_Types.mysteryInputOption(Some("Arsenal")) shouldBe Some('A')
    Exercise_3_Types.mysteryInputOption(Some("")) shouldBe None
    Exercise_3_Types.mysteryInputOption(Some(100)) shouldBe Some(50)
    Exercise_3_Types.mysteryInputOption(Some(3)) shouldBe Some(1)
    Exercise_3_Types.mysteryInputOption(Some(3.14)) shouldBe Some(0)
    Exercise_3_Types.mysteryInputOption(Some(-1.0)) shouldBe Some(-1)
    Exercise_3_Types.mysteryInputOption(Some(Instant.now())) shouldBe None
    Exercise_3_Types.mysteryInputOption(None) shouldBe None
  }

}