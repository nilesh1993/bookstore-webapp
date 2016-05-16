package controllers

import java.net.URI

import com.marklogic.xcc.{ResultSequence, Session, ContentSourceFactory}
import play.api.libs.json.Json
import play.api.libs.ws.WS
import play.api.libs.ws.WSAuthScheme.DIGEST
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class SearchBookService {

  def searchBook(bookId: String, dropdownValue: String): Future[Either[(Int, String), String] with Product with Serializable] = {

    val searchTerm = dropdownValue
    val searchValue = bookId
    val result: Future[Either[(Int, String), String] with Product with Serializable] = postToMl("http://localhost:8004/search.xqy", Map("searchTerm" -> searchTerm, "searchValue" -> searchValue))
    result
//    println("result===========>>>>>>>>>>"+result)
//
//    result map {
//
//        case Right(str)=>Json.toJson(str)
//                              println("str"+str)
//        str
//
//
//    }




//    val uri :URI = new URI("xcc://admin:admin@localhost:8050/bookStore");
//    val contentSource = ContentSourceFactory.newContentSource(uri);
//    val session = contentSource.newSession();
//    var query: String = ""
//    val drop="$book//"+dropdownValue+""
//    session.setTransactionMode(Session.TransactionMode.UPDATE);

//    dropdownValue match {
//      case _ => query = "cts:search(//Book, cts:element-value-query(xs:QName(\"" + dropdownValue+ "\"), \"" + bookId + "\"))"
//      case "element"=> query="cts:search(/,cts:word-query(\"" + bookId.toList.head + "\"))"
//    }

//    val rs: ResultSequence =session.submitRequest(session.newAdhocQuery("for $book in doc('catalogg.xml')//Book where "+drop+" = (\""+bookId+"\") return ($book//bookId,   $book//bookName,   $book//bookAuthor)"));
//    session.commit();
//    session.close();
//
//    rs

  }
  def postToMl(url:String, body: Map[String, String])= {
    println("postToMl=====================>>>>>>>>>>>")
    val params = for((k,v) <- body) yield(k -> Seq(v))
    WS.url(url)
      .withAuth("admin", "admin", DIGEST)
      .post(params.toMap)
      .map(response => {
        response.status match {
          case 200 => {
            println("In right..."+response.body)

            val rs = new String(response.body.getBytes)
            println("rs==========="+rs)
            Right(new String(response.body.getBytes))



          }
          case _ => Left((response.status , response.body.trim))

        }
      })
  }

}
