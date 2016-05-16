package controllers

import java.net.URI

import com.marklogic.xcc.{Session, ContentSourceFactory}
import play.api.mvc._
import controllers.Dependencies._
import services.MarklogicService


object Application extends Controller {

  def index = Action {
    val marklogicservice = new MarklogicService("xcc://admin:admin@localhost:9999","book", "book-modules")

    marklogicservice.exec("/Users/njm1688/bookstore-webapp/scripts/setup")
    marklogicservice.loadDirectory("/Users/njm1688/bookstore-webapp/scripts/queries")

    Ok(defaultJadeRenderer.render("main"))
  }
}

object Render extends JadeRenderController(defaultJadeRenderer)

object add extends AddBookController(defaultJadeRenderer)

object delete extends deleteBookController(defaultJadeRenderer)

object search extends SearchBookController(defaultJadeRenderer)

object update extends UpdateBookController(defaultJadeRenderer)