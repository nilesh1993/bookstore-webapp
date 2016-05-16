package controllers

import java.net.URI

import com.marklogic.xcc.{ResultSequence, Session, ContentSourceFactory}

import play.api.libs.json.JsValue
import play.api.libs.ws.WS
import play.api.Play.current
import play.api.libs.ws.WSAuthScheme.DIGEST
import scala.concurrent.ExecutionContext.Implicits.global

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
    //println("Request : ", request.getQuery.toString)
    session.submitRequest(request)
    session.commit();
    session.close();


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
