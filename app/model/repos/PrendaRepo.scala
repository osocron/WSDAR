package model.repos

import javax.inject.Inject

import model.Tables.{Prenda, PrendaRow}
import play.api.db.slick.DatabaseConfigProvider
import slick.lifted.TableQuery

/**
  * Created by osocron on 18/11/16.
  */
class PrendaRepo @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends RepositoryUtils[Prenda, PrendaRow] {
  override val t: TableQuery[Prenda] = TableQuery[Prenda]
}
