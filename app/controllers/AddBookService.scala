package controllers

import java.net.URI

import com.marklogic.xcc.{Session, ContentSourceFactory}
import play.api.libs.json.JsValue

/**
 * Created by njm1688 on 4/28/16.
 */
class AddBookService() {

  def addBook(book:JsValue)={

    val uri: URI = new URI("xcc://admin:admin@localhost:8050/bookStore");
    val contentSource = ContentSourceFactory.newContentSource(uri);
    val session = contentSource.newSession();
    session.setTransactionMode(Session.TransactionMode.UPDATE);
    session.submitRequest(session.newAdhocQuery("xdmp:node-insert-child(doc('catalogg.xml')/BookStore,<Book><bookId>"+book.\("BookId").as[String]+"</bookId><bookName>"+book.\("BookName").as[String]+"</bookName><bookAuthor>"+book.\("BookAuthor").as[String]+"</bookAuthor></Book>)"))
    session.commit();
    session.close();
  }

}
