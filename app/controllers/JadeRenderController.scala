package controllers

import java.net.URI

import play.api.mvc._
import com.marklogic.xcc.{Session, ContentSourceFactory}

class JadeRenderController(renderer: JadeRenderer) extends Controller {

  def renderPage() = Action{


    request => {

      val name: String = "Nilesh"
      val bookId: Seq[String] = request.body.asFormUrlEncoded.get("BookId")
      val bookName: Seq[String] = request.body.asFormUrlEncoded.get("BookName")
      val bookAuthor = request.body.asFormUrlEncoded.get("BookAuthor")
     // println("BookId-------->" + bookId)

          val node: String ="<Book>"+name.toList+"</Book>"
          val id="1"
          //val name="bookId"

          val uri :URI = new URI("xcc://admin:admin@localhost:8050/bookStore");
          val contentSource = ContentSourceFactory.newContentSource(uri);
          val session = contentSource.newSession();

          session.setTransactionMode(Session.TransactionMode.UPDATE);
          //val rs=session.submitRequest(session.newAdhocQuery("xdmp:document-insert('catalogg.xml', <BookStore><Book><bookId>"+bookId.toList.head+"</bookId><bookName>"+bookName.toList.head+"</bookName><bookAuthor>"+bookAuthor.toList.head+"</bookAuthor></Book></BookStore>, xdmp:default-permissions(), /collections/doc1)"));
          //val rs=session.submitRequest(session.newAdhocQuery("xdmp:document-delete('catalogg.xml')"));
          //val rs=session.submitRequest(session.newAdhocQuery("xdmp:node-insert-child(doc('catalogg.xml')/BookStore,<Book><bookId>"+bookId.toList.head+"</bookId><bookName>"+bookName.toList.head+"</bookName><bookAuthor>"+bookAuthor.toList.head+"</bookAuthor></Book>)"))
          //val rs=session.submitRequest(session.newAdhocQuery("xdmp:node-replace(doc('mrun.xml')//Book, "+node+")"));
          //val rs=session.submitRequest(session.newAdhocQuery("for $book in doc('catalogg.xml')//Book where $book//bookId = "+id+" return ($book//bookId/text(), $book//bookName/text(), $book//bookAuthor/text())"));
          val rs2=session.submitRequest(session.newAdhocQuery("doc('catalogg.xml')"))
          val rs=session.submitRequest(session.newAdhocQuery("for $book in doc('catalogg.xml')//Book where $book//bookId = "+id+" return ($book)"));
          //val rs1=session.submitRequest(session.newAdhocQuery("xdmp:node-delete(doc('catalogg.xml')/"+rs.asString()+")"))
          println(rs.asString())
          println(rs2.asString())
          //rs.asString().toList.filter(_)

          session.commit();

          //val Request = session.newAdhocQuery("\"Hello World\"");
          //val  rs = session.submitRequest(Request);
          //println("result--- "+rs.asString());
          session.close();




      Ok(renderer.render("next", "bookId" -> bookId, "bookName" -> bookName, "bookAuthor" -> bookAuthor))
    }
  }


}

