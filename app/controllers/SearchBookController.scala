package controllers


import models.book
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

import scala.collection.immutable.Seq
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.xml.NodeSeq


class SearchBookController(renderer: JadeRenderer) extends Controller {

  def searchBook(id: String, value: String) = Action.async {

    request => {

      val searchService = new SearchBookService()
      val rs: Future[Either[(Int, String), String] with Product with Serializable] = searchService.searchBook(id, value)

      rs.map {

        case Right(str: String) =>
          println("str=====" + str)
          val x = scala.xml.XML.loadString(str)
          val seq: Seq[book] = (x \\ "result").map{

            node =>
              println("hi---------")
              val uri= (node \\ "uri").head.text
              val id= (node \\ "bookId").head.text
              val name= (node \\ "bookName").head.text
              val author= (node \\ "bookAuthor").head.text

              book(uri,id,name,author)

          }
          println("seq==========>" + seq)
          println("-------------------------------->")
          //val a: JsValue = convertTweetsToJsonOrig(seq)
          //println("a///////////"+a)
          Ok(renderer.render("searchResult", "objects" -> seq))
      }


    }
  }

  def renderSearchPage()=Action{
    Ok(renderer.render("searchBook"))
  }

  def convertTweetsToJsonOrig(books: Seq[book]): JsValue = {
    Json.toJson(
      books.map { t =>
        Map("uri" -> t.uri, "bookId" -> t.bookId, "bookName" -> t.bookName ,"bookAuthor" -> t.bookAuthor)
      }
    )
  }
}


//      val result: Future[Result] = rs.map{
//        case Right(response) => Ok(Json.toJson(response))
//        case Left((status, response)) => Ok("Failed")
//      }
//      result
/*println("finalResult=========>>>>>"+finalresult)

Ok(Json.toJson(finalresult))*/

//      val abc = Json.toJson(rs.asString())
//      if(rs.isEmpty){
//        NotFound("No data found")
//      }
//      else {
//        Ok(Json.toJson(rs.asString()))
//
//      }