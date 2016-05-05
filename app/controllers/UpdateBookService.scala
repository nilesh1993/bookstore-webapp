package controllers

import java.net.URI

import com.marklogic.xcc.{Session, ContentSourceFactory, ResultSequence}
import play.api.libs.json.JsValue

/**
 * Created by njm1688 on 5/4/16.
 */
class UpdateBookService {

    def updateBook(updateBookData:JsValue)={

      val uri: URI = new URI("xcc://admin:admin@localhost:8050/bookStore");
      val contentSource = ContentSourceFactory.newContentSource(uri);
      val session = contentSource.newSession();
      val dropDown = "$record//"+updateBookData.\("dropdown").as[String]+""
      println("DropDown-------------"+dropDown)
      session.setTransactionMode(Session.TransactionMode.UPDATE);
      session.submitRequest(session.newAdhocQuery("for $doc in doc()\nlet $result := for $record in $doc//Book \n where "+dropDown+" = \""+updateBookData.\("old").as[String]+"\" \n   return "+dropDown+"\nlet $node := xdmp:node-replace($doc/$result, <"+updateBookData.\("dropdown").as[String]+">"+updateBookData.\("new").as[String]+"</"+updateBookData.\("dropdown").as[String]+">)\nreturn $node"))
      //println("for $doc in doc()\nlet $result := for $record in $doc//Book \n where "+dropDown+" = \""+updateBookData.\("old").as[String]+"\" \n   return $record//bookId\nlet $node := xdmp:node-replace($doc/$result, <"+updateBookData.\("dropdown").as[String]+">"+updateBookData.\("new").as[String]+"</"+updateBookData.\("dropdown").as[String]+">)\nreturn $node")
      session.commit();
      session.close();

  }
}
