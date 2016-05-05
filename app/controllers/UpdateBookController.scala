package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
 * Created by njm1688 on 5/4/16.
 */
class UpdateBookController(renderer: JadeRenderer) extends Controller {

  def update() = Action {

    request=> {
      println("In update controller")
      val updateBookData = request.body.asJson.get
      val updateService = new UpdateBookService()
      updateService.updateBook(updateBookData)

      Ok(request.body.asJson.get)
    }
  }
  def renderUpdatePage()= Action{

    Ok(renderer.render("updateBook"))
  }

}
