package controllers

import java.net.URI

import com.marklogic.xcc.{ResultSequence, Session, ContentSourceFactory}
import play.api.libs.json.JsValue

/**
 * Created by njm1688 on 4/29/16.
 */
class DeleteBookService {

  def delete(deleteBook:JsValue)={

    val uri :URI = new URI("xcc://admin:admin@localhost:8050/bookStore");
    val contentSource = ContentSourceFactory.newContentSource(uri);
    val session = contentSource.newSession();
    val drop="$book//"+deleteBook.\("mydropdown").as[String]+""

    session.setTransactionMode(Session.TransactionMode.UPDATE);
    val request = session.newAdhocQuery("let $doc := doc('catalogg.xml')\n\nlet $result := for $book in $doc//Book\n                  where "+drop+" = \""+deleteBook.\("BookId").as[String]+"\"\n                  return $book\n                  \nlet $node := xdmp:node-delete($doc//$result)\n\nreturn $node")
    println("Request : ", request.getQuery.toString)
    session.submitRequest(request)
    session.commit();
    session.close();

  }



}
