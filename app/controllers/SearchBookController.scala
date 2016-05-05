package controllers

import java.net.URI

import com.marklogic.xcc.{ResultSequence, Session, ContentSourceFactory}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._


/**
 * Created by njm1688 on 4/20/16.
 */
class SearchBookController(renderer: JadeRenderer) extends Controller {

  def searchBook(id:String, value:String) = Action {

    request => {

      val searchService = new SearchBookService()
      val rs: ResultSequence = searchService.searchBook(id,value)

      val abc = Json.toJson(rs.asString())
      if(rs.isEmpty){
        NotFound("No data found")
      }
      else {
        Ok(Json.toJson(rs.asString()))

      }
    }
  }

  def renderSearchPage()=Action{
    Ok(renderer.render("searchBook"))
  }

}
