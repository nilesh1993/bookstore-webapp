package controllers

import java.net.URI

import com.marklogic.xcc.{Session, ContentSourceFactory}
import play.api.mvc._
import controllers.Dependencies._


object Application extends Controller {

  def index = Action {

    val uri = new URI("xcc://admin:admin@localhost:8050/bookStore");
    val contentSource = ContentSourceFactory.newContentSource(uri);
    val session = contentSource.newSession();
    session.setTransactionMode(Session.TransactionMode.UPDATE);

    session.submitRequest(session.newAdhocQuery("xdmp:document-insert('catalogg.xml', <BookStore></BookStore>)"));
    println("hi")
    session.commit();
    session.close();

    Ok(defaultJadeRenderer.render("main"))

  }
}

object Render extends JadeRenderController(defaultJadeRenderer)

object add extends AddBookController(defaultJadeRenderer)

object delete extends deleteBookController(defaultJadeRenderer)

object search extends SearchBookController(defaultJadeRenderer)

object update extends UpdateBookController(defaultJadeRenderer)