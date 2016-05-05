package controllers

import play.api.mvc.{Controller, Action}

/**
 * Created by njm1688 on 4/28/16.
 */
class deleteBookController(renderer: JadeRenderer) extends Controller{

  def deleteBook() = Action {

    request => {

      val deleteData = request.body.asJson.get
      val deleteService = new DeleteBookService()
      deleteService.delete(deleteData)

      Ok(request.body.asJson.get)

    }
  }

    def renderDeletePage()=Action{

      Ok(renderer.render("deleteBook"))
    }

}
