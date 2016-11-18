package model.repos

import play.api.db.slick.HasDatabaseConfigProvider

import scala.concurrent.Future
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

/**
  * This trait abstracts many of the common operations on data tables
  *
  * @tparam A The table type in the relational database. This type must
  *           be a subtype of `Table[B]`.
  * @tparam B Given a tye `AccountTable` which is a subclass of `Table[Account]`
  *           B would be `Account`
  */
trait RepositoryUtils[A <: Table[B], B] extends HasDatabaseConfigProvider[JdbcProfile] {

  /**
    * The table to be queried.
    */
  val t: TableQuery[A]

  /**
    * Queries a table to get a result based on a predicate
    *
    * @param p The predicate to be applied
    * @return  The possibility of a future computation that contains
    *          the possibility of an element of type `B`
    */
  def queryByPredicate (p: (A => Rep[Boolean])): Future[Option[B]] = {
    val query = t.filter(p)
    db.run(query.result.headOption)
  }

  /**
    * Queries a table and gets all the results
    *
    * @return  The possibility of a future computation containing a
    *          sequence of elements of type `B`
    */
  def getAll: Future[Seq[B]] = db.run(t.result)

  /**
    * Queries a table to see if an element exists based on a predicate
    *
    * @param p The predicate to be applied
    * @return  The possibility of a future computation containing a Boolean
    */
  def queryIfExists(p: (A => Rep[Boolean])): Future[Boolean] = {
    val query = t.filter(p)
    db.run(query.exists.result)
  }

  /**
    * Abstract add function for single elements of type B
    *
    * @param e The element to be added
    * @return  `ok` if the element was successfully added or the exception message otherwise.
    */
  def add(e: B): Future[Int] = db.run(t += e)

  /**
    * Deletes elements based on a predicate.
    *
    * @param p The predicate used to delete the elements
    * @return  either (1) the row count for SQL Data Manipulation Language (DML)
    *          statements or (2) 0 for SQL statements that return nothing
    */
  def deleteByPredicate(p: (A => Rep[Boolean])): Future[Int] = db.run(t.filter(p).delete)

  /**
    * Updates a row in the table by applying the filtering function in order to find the
    * row to be updated
    *
    * @param e  The row with the updated info
    * @param p  The predicate to find the row to replace
    * @return   either (1) the row count for SQL Data Manipulation Language (DML)
    *          statements or (2) 0 for SQL statements that return nothing
    */
  def updateRow(e: B)(p: (A => Rep[Boolean])): Future[Int] = {
    val query = t.filter(p).update(e)
    db.run(query)
  }

}
