package controllers

import javax.inject.Inject

import io.circe.generic.auto._
import io.circe.syntax._
import model.Tables.{CatalogoRow, CategoriaRow}
import model.repos.{CatalgoRepo, CategoriaRepo, PrendaRepo, RepositoryUtils}
import slick.driver.MySQLDriver.api.Table
import play.api.libs.circe.Circe
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject()(catalgoRepo: CatalgoRepo,
                            categoriaRepo: CategoriaRepo,
                            prendaRepo: PrendaRepo) extends Controller with Circe {

  case class Message(error: Boolean = false, message: String)

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def catalogos = Action.async { request =>
    for { c <- catalgoRepo.getAll } yield Ok(c.asJson.noSpaces)
  }

  def catalogo = Action.async(circe.json[CatalogoRow]) { request =>
    insertAction(request, catalgoRepo)
  }

  def categorias = Action.async { request =>
    for { c <- categoriaRepo.getAll } yield Ok(c.asJson.noSpaces)
  }

  def categoria = Action.async(circe.json[CategoriaRow]) { request =>
    insertAction(request, categoriaRepo)
  }

  def prendas = Action.async { request =>
    for { p <- prendaRepo.getAll } yield Ok(p.asJson.noSpaces)
  }

  def insertAction[A <: Table[B], B](request: Request[B], repo: RepositoryUtils[A, B]) =
    (for {
      r <- repo.add(request.body)
    } yield Ok(Message(error = false,
      "Agregado satisfactoriamente").asJson.noSpaces)).recover {
      case cause => Ok(Message(error = true,
        cause.getMessage).asJson.noSpaces)
    }

}