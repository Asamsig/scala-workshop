package no.asamsig.exercises.part2

import no.asamsig.exercises.part2.Exercise_1_Classes.Task
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import reflect.runtime.{universe => ru}

class Exercise_1_ClassesTest extends AnyFreeSpec with Matchers {

  "1. An instance of Task should be returned" in {
    val task = Exercise_1_Classes.taskInstanse()
    task shouldBe a[Task]
    task.description shouldBe "Buy milk"
    task.priority shouldBe 1
    task.id shouldBe 100
  }

  "2. A 'completed' property should be added to Task" in {
    val task = Exercise_1_Classes.completedTask()

    // Uses reflection to check property so it will compile even before the exercise is done
    val completed = classOf[Task].getDeclaredMethods.find(_.getName == "completed")
    val constructor = classOf[Task].getConstructors.headOption
    constructor should not be empty
    withClue("Task should have a constructor taking 4 arguments:") {
      constructor.get.getParameterCount shouldBe 4
    }
    withClue("The last constructor argument should be have a default:") {
      ru.typeOf[Task].decl(ru.termNames.CONSTRUCTOR).asMethod.paramLists.head(3).asTerm.isParamWithDefault shouldBe true
    }
    withClue("Task should have a property named 'completed':") {
      completed should not be empty
    }
    withClue("The property 'completed' should be 'true':") {
      completed.map(_.invoke(task)) shouldBe Some(true)
    }
  }

  "3. Task should implement the 'Comparable' interface" in {
    val t1 = new Task(1, "", 10)
    val t2 = new Task(2, "", 11)

    Exercise_1_Classes.comparable(t1, t2) shouldBe -1
    Exercise_1_Classes.comparable(t1, t1) shouldBe 0
    Exercise_1_Classes.comparable(t2, t1) shouldBe 1

    withClue("Task should implement the 'Ordered' interface") {
      classOf[Task].getInterfaces.toList.headOption shouldBe Some(classOf[Ordered[_]])
    }
    val compareTo = classOf[Task].getDeclaredMethods.find(_.getName == "compareTo")
    compareTo.map(_.invoke(t1, t2)) shouldBe Some(-1)
  }

  "4. Equality" in {
    val t1 = new Task(1, "Foo", 10)
    val t2 = new Task(1, "Foo", 10)
    val t3 = new Task(2, "Foo", 10)
    val t4 = new Task(1, "Bar", 10)
    val t5 = new Task(1, "Foo", 11)
    Exercise_1_Classes.equality(t1, t1) shouldBe true
    Exercise_1_Classes.equality(t1, t2) shouldBe true
    Exercise_1_Classes.equality(t1, t3) shouldBe false
    Exercise_1_Classes.equality(t1, t4) shouldBe false
    Exercise_1_Classes.equality(t1, t5) shouldBe false
  }

  "5. Case class" in {
    val t1 = new Task(1, "Foo", 10)
    val t2 = new Task(1, "Foo", 10)
    val t3 = new Task(2, "Foo", 10)
    val t4 = new Task(1, "Bar", 10)
    val t5 = new Task(1, "Foo", 11)
    Exercise_1_Classes.dataClassEquality(t1, t1) shouldBe true
    Exercise_1_Classes.dataClassEquality(t1, t2) shouldBe true
    Exercise_1_Classes.dataClassEquality(t1, t3) shouldBe false
    Exercise_1_Classes.dataClassEquality(t1, t4) shouldBe false
    Exercise_1_Classes.dataClassEquality(t1, t5) shouldBe false
    withClue("Task is not a case class: ") {
      ru.typeOf[Task].typeSymbol.asClass.isCaseClass shouldBe true
    }
  }

  "6. Copy" in {
    val completed = classOf[Task].getDeclaredMethods.find(_.getName == "completed")
    withClue("Task should have a property named 'completed':") {
      completed should not be empty
    }
    withClue("Task should be a case class: ") {
      ru.typeOf[Task].typeSymbol.asClass.isCaseClass shouldBe true
    }
    val task = new Task(1, "Foo", 10)
    val copy = Exercise_1_Classes.copyAndComplete(task)
    withClue("The property 'completed' should be 'true':") {
      completed.map(_.invoke(copy)) shouldBe true
    }
  }

}