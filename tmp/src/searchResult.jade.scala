/* NOTE this file is autogenerated by Scalate : see http://scalate.fusesource.org/ */

import _root_.scala.collection.JavaConversions._
import _root_.org.fusesource.scalate.support.TemplateConversions._
import _root_.org.fusesource.scalate.util.Measurements._

object $_scalate_$searchResult_jade {
  def $_scalate_$render($_scalate_$_context: _root_.org.fusesource.scalate.RenderContext): Unit = {
    import _root_.org.fusesource.scalate.support.RenderHelper.{sanitize=>$_scalate_$_sanitize, preserve=>$_scalate_$_preserve, indent=>$_scalate_$_indent, smart_sanitize=>$_scalate_$_smart_sanitize, attributes=>$_scalate_$_attributes}
    ;{
      val context: _root_.org.fusesource.scalate.RenderContext = $_scalate_$_context.attribute("context")
      import context._
      
      
            import models.book

      ;{
        val objects: Seq[book] = $_scalate_$_context.attribute("objects")
                var itr = 0

                var ittr = 0

        $_scalate_$_context << ( "<html>\n  <head>\n    <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n    <script type=\"text/javascript\" src=\"/assets/delete.js\"></script>\n    <script type=\"text/javascript\" src=\"/assets/update.js\"></script>\n    <title>result</title>\n  </head>\n  <body></body>\n  <form action=\"deleteData\" method=\"post\" id=\"deleteForm\">\n    <table border=\"1\">\n" );
                for(result <- objects)
{
          $_scalate_$_context << ( "      <tr>\n        <td>\n          <input" );
          $_scalate_$_context << $_scalate_$_attributes( $_scalate_$_context, List( (
              "type"
            ,
              "hidden"
            ), (
              "id"
            ,
              "foo_" + $_scalate_$_context.value(              ittr
, false) + ""
            ), (
              "value"
            ,
              "" + $_scalate_$_context.value(              result.uri
, false) + ""
          ) ) )
          $_scalate_$_context << ( "/>\n        </td>\n        <td>\n          <input" );
          $_scalate_$_context << $_scalate_$_attributes( $_scalate_$_context, List( (
              "type"
            ,
              "text"
            ), (
              "id"
            ,
              "bookId_" + $_scalate_$_context.value(              ittr
, false) + ""
            ), (
              "value"
            ,
              "" + $_scalate_$_context.value(              result.bookId
, false) + ""
          ) ) )
          $_scalate_$_context << ( "/>\n        </td>\n        <td>\n          <input" );
          $_scalate_$_context << $_scalate_$_attributes( $_scalate_$_context, List( (
              "type"
            ,
              "text"
            ), (
              "id"
            ,
              "bookName_" + $_scalate_$_context.value(              ittr
, false) + ""
            ), (
              "value"
            ,
              "" + $_scalate_$_context.value(              result.bookName
, false) + ""
          ) ) )
          $_scalate_$_context << ( "/>\n        </td>\n        <td>\n          <input" );
          $_scalate_$_context << $_scalate_$_attributes( $_scalate_$_context, List( (
              "type"
            ,
              "text"
            ), (
              "id"
            ,
              "bookAuthor_" + $_scalate_$_context.value(              ittr
, false) + ""
            ), (
              "value"
            ,
              "" + $_scalate_$_context.value(              result.bookAuthor
, false) + ""
          ) ) )
          $_scalate_$_context << ( "/>\n        </td>\n        <td>\n          <input" );
          $_scalate_$_context << $_scalate_$_attributes( $_scalate_$_context, List( (
              "type"
            ,
              "button"
            ), (
              "value"
            ,
              "Update"
            ), (
              "id"
            ,
              "udpateButton_" + $_scalate_$_context.value(              ittr
, false) + ""
            ), (
              "class"
            ,
              "udpateButton"
          ) ) )
          $_scalate_$_context << ( "/>\n        </td>\n        <td>\n          <input" );
          $_scalate_$_context << $_scalate_$_attributes( $_scalate_$_context, List( (
              "type"
            ,
              "button"
            ), (
              "value"
            ,
              "Delete"
            ), (
              "id"
            ,
              "deletebutton_" + $_scalate_$_context.value(              ittr
, false) + ""
            ), (
              "class"
            ,
              "deletebutton"
          ) ) )
          $_scalate_$_context << ( "/>\n" );
                    ittr = itr+1

          $_scalate_$_context << ( "        </td>\n      </tr>\n" );
        }
        $_scalate_$_context << ( "    </table>\n  </form>\n</html>\n" );
      }
    }
  }
}


class $_scalate_$searchResult_jade extends _root_.org.fusesource.scalate.Template {
  def render(context: _root_.org.fusesource.scalate.RenderContext): Unit = $_scalate_$searchResult_jade.$_scalate_$render(context)
}
