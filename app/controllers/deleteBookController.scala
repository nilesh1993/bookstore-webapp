package controllers

import play.api.mvc.{Controller, Action}

/**
 * Created by njm1688 on 4/28/16.
 */
class deleteBookController(renderer: JadeRenderer) extends Controller{

  def deleteBook() = Action {

    request => {

      val deleteData = request.body.asJson.get
      println("deleteData"+deleteData.toString())
      val deleteService = new DeleteBookService()
      deleteService.postToMl("http://localhost:8004/delete.xqy", Map("deleteData"-> deleteData.as[String]))

      Ok(request.body.asJson.get)

    }
  }

    def renderDeletePage()=Action{

      Ok(renderer.render("deleteBook"))
    }

}
