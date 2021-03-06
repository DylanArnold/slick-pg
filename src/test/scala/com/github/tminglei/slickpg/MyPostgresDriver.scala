package com.github.tminglei.slickpg

trait MyPostgresDriver extends ExPostgresDriver
                          with PgArraySupport
                          with PgDateSupport
                          with PgRangeSupport
                          with PgHStoreSupport
                          with PgSearchSupport {
  ///
  override lazy val Implicit = new ImplicitsPlus {}
  override val simple = new SimpleQLPlus {}

  //////
  trait ImplicitsPlus extends Implicits
                        with ArrayImplicits
                        with DateTimeImplicits
                        with RangeImplicits
                        with HStoreImplicits
                        with SearchImplicits

  trait SimpleQLPlus extends SimpleQL
                        with ImplicitsPlus
                        with SearchAssistants
}

object MyPostgresDriver extends MyPostgresDriver
