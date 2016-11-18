package model.repos

import javax.inject.Inject

import play.api.db.slick.DatabaseConfigProvider
import model.Tables.{Categoria, CategoriaRow}
import slick.lifted.TableQuery

/**
  * Created by osocron on 18/11/16.
  */
class CategoriaRepo @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends RepositoryUtils[Categoria, CategoriaRow] {
  override val t: TableQuery[Categoria] = TableQuery[Categoria]
}
