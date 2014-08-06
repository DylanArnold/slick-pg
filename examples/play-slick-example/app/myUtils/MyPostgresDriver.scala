package myUtils

import com.github.tminglei.slickpg._
import com.github.tminglei.slickpg.composite.Struct
import slick.driver.PostgresDriver

trait WithMyDriver {
  val driver: MyPostgresDriver
}

////////////////////////////////////////////////////////////
trait MyPostgresDriver extends PostgresDriver
                          with PgArraySupport
                          with PgDateSupportJoda
                          with PgRangeSupport
                          with PgHStoreSupport
                          with PgPlayJsonSupport
                          with PgSearchSupport
                          with PgPostGISSupport
                          with PgCompositeSupport {

  override lazy val Implicit = new ImplicitsPlus {}
  override val simple = new SimpleQLPlus {}

  //////
  trait ImplicitsPlus extends Implicits
                        with ArrayImplicits
                        with DateTimeImplicits
                        with RangeImplicits
                        with HStoreImplicits
                        with JsonImplicits
                        with SearchImplicits
                        with PostGISImplicits
                        with CompositeImplicits

  trait SimpleQLPlus extends SimpleQL
                        with ImplicitsPlus
                        with SearchAssistants
                        with PostGISAssistants

  trait CompositeImplicits {
    implicit val composite1TypeMapper = createCompositeJdbcType[Composite1]("comp")
    implicit val composite1ArrayTypeMapper = createCompositeListJdbcType[Composite1]("comp")
  }
}

case class Composite1(c1: Int, c2: Int) extends Struct

object MyPostgresDriver extends MyPostgresDriver
