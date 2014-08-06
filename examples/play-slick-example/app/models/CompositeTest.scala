package models

import myUtils.{Composite1, WithMyDriver}

case class Foo(
   id: Int,
   composite: Composite1
)

trait CompositeTestComponent extends WithMyDriver {
  import driver.simple._

  class CompositeTests(tag: Tag) extends Table[Foo](tag, "composite_test") {
    def id = column[Int]("id")
    def composite = column[Composite1]("composite")
    def * = (id, composite) <> (Foo.tupled, Foo.unapply)
  }
}
