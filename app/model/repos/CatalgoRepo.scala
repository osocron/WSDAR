package model.repos

import javax.inject.Inject

import model.Tables.{Catalogo, CatalogoRow}
import play.api.db.slick.DatabaseConfigProvider
import slick.lifted.TableQuery

/**
  * Created by osocron on 18/11/16.
  */
class CatalgoRepo @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends RepositoryUtils[Catalogo, CatalogoRow] {
  override val t: TableQuery[Catalogo] = TableQuery[Catalogo]
}
