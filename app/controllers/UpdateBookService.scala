package controllers


import java.net.URI

import com.marklogic.xcc.{Session, ContentSourceFactory, ResultSequence}
import play.api.libs.json.JsValue
import play.api.libs.ws.WS
import play.api.libs.ws.WSAuthScheme.DIGEST
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by njm1688 on 5/4/16.
 */
class UpdateBookService {

    def updateBook(updateBookData:JsValue)={


      val uri = updateBookData.\("uri").as[String]
      val bookId = updateBookData.\("bookId").as[String]
      val bookName = updateBookData.\("bookName").as[String]
      val bookAuthor = updateBookData.\("bookAuthor").as[String]

      postToMl("http://localhost:8004/update.xqy", Map("uri" -> uri, "bookId" -> bookId, "bookName" -> bookName, "bookAuthor" -> bookAuthor))

//      val uri: URI = new URI("xcc://admin:admin@localhost:8050/bookStore");
//      val contentSource = ContentSourceFactory.newContentSource(uri);
//      val session = contentSource.newSession();
//      val dropDown = "$record//"+updateBookData.\("dropdown").as[String]+""
//      println("DropDown-------------"+dropDown)
//      session.setTransactionMode(Session.TransactionMode.UPDATE);
//      session.submitRequest(session.newAdhocQuery("for $doc in doc()\nlet $result := for $record in $doc//Book \n where "+dropDown+" = \""+updateBookData.\("old").as[String]+"\" \n   return "+dropDown+"\nlet $node := xdmp:node-replace($doc/$result, <"+updateBookData.\("dropdown").as[String]+">"+updateBookData.\("new").as[String]+"</"+updateBookData.\("dropdown").as[String]+">)\nreturn $node"))
//      //println("for $doc in doc()\nlet $result := for $record in $doc//Book \n where "+dropDown+" = \""+updateBookData.\("old").as[String]+"\" \n   return $record//bookId\nlet $node := xdmp:node-replace($doc/$result, <"+updateBookData.\("dropdown").as[String]+">"+updateBookData.\("new").as[String]+"</"+updateBookData.\("dropdown").as[String]+">)\nreturn $node")
//      session.commit();
//      session.close();

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
