package controllers

import java.net.URI

import com.marklogic.xcc.{Session, ContentSourceFactory}
import play.api.libs.json.JsValue
import play.api.libs.ws.WS
import play.api.libs.ws.WSAuthScheme.DIGEST
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by njm1688 on 4/28/16.
 */
class AddBookService() {

  def addBook(book:JsValue)={

    val r= scala.util.Random
    val nextXml= r.nextInt().toString
    val bookId = book.\("BookId").as[String]
    val bookName = book.\("BookName").as[String]
    val bookAuthor = book.\("BookAuthor").as[String]
    println("values=======---------->>>>>"+nextXml,bookId,bookName)

    postToMl("http://localhost:8004/addBook.xqy", Map("nextXml" -> nextXml, "bookId" -> bookId, "bookName" -> bookName, "bookAuthor" -> bookAuthor))



//    val uri: URI = new URI("xcc://admin:admin@localhost:8050/bookStore");
//    val contentSource = ContentSourceFactory.newContentSource(uri);
//    val session = contentSource.newSession();
//    session.setTransactionMode(Session.TransactionMode.UPDATE);
//    //session.submitRequest(session.newAdhocQuery("xdmp:node-insert-child(doc('catalogg.xml')/BookStore,<Book><bookId>"+book.\("BookId").as[String]+"</bookId><bookName>"+book.\("BookName").as[String]+"</bookName><bookAuthor>"+book.\("BookAuthor").as[String]+"</bookAuthor></Book>)"))
//    session.submitRequest(session.newAdhocQuery("xdmp:document-insert('catalogg\""+nextXml+"\".xml', <BookStore><book xmlns=\""+nextXml+"\"><bookId>"+book.\("BookId").as[String]+"</bookId><bookName>"+book.\("BookName").as[String]+"</bookName><bookAuthor>"+book.\("BookAuthor").as[String]+"</bookAuthor></book></BookStore>)"))
//    session.commit();
//    session.close();
  }

  def postToMl(url:String, body: Map[String, String]) = {
    println("postToMl=====================>>>>>>>>>>>"+body)
    val params = for((k,v) <- body) yield(k -> Seq(v))
    WS.url(url)
      .withAuth("admin", "admin", DIGEST)
      .post(params.toMap)
      .map(response => {
        response.status match {
          case 200 => {
            Right(response.body.getBytes)
          }
          case _ => Left((response.status , response.body.trim))
        }
      }) recover {
      case e: java.net.ConnectException => Left((503, "Service Unavailable"))
    }
  }

}
