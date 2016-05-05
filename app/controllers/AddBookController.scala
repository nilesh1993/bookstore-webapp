package controllers

import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Controller, Action}

import scala.util.parsing.json.JSONObject

/**
 * Created by njm1688 on 4/28/16.
 */
class AddBookController(renderer: JadeRenderer) extends Controller {

  def addBook() = Action{

    request => {

      val book: JsValue = request.body.asJson.get
      val addService: AddBookService = new AddBookService()
      addService.addBook(book)

      Ok(book)

    }

  }

  def renderAddPage()=Action{

    Ok(renderer.render("addBook"))
  }

}
