package no.asamsig.service

package object petstore {

  type PetId = Long
  type CategoryId = Long
  type TagId = Long

  sealed trait Status
  case object Available extends Status
  case object Pending extends Status
  case object Sold extends Status

  trait PetStoreService {
    def findById(petId: PetId): Option[Pet]
  }

  trait Pet {
    val id: PetId
    val name: String
    val category: Option[Category]
    val tags: Option[Set[Tag]]
  }

  trait Category {
    val id: CategoryId
    val name: String
  }

  trait Tag {
    val id: TagId
    val name: String
  }

}
