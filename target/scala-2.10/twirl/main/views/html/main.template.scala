
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>Just Play Scala</title>
    </head>
    <body>
        <form action="next" method="get">
            <h1>Just Play Scala</h1>
            <input type="submit" value="submit"/>

        </form>
    </body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon May 02 14:39:44 IST 2016
                  SOURCE: /Users/njm1688/MyProjects/NewProjectRender/app/views/main.scala.html
                  HASH: acff89b070d968ceaa972c73890079b8852ec4f3
                  MATRIX: 579->0
                  LINES: 22->1
                  -- GENERATED --
              */
          