package com.github.tminglei.slickpg

import scala.slick.driver.PostgresDriver

object MyPostgresDriver extends PostgresDriver
                           with PgSprayJsonSupport
                           with array.PgArrayJdbcTypes {

  override lazy val Implicit = new Implicits with JsonImplicits
  override val simple = new Implicits with SimpleQL with JsonImplicits {
    implicit val strListTypeMapper = new SimpleArrayListJdbcType[String]("text")
  }
}
