/* NOTE this file is autogenerated by Scalate : see http://scalate.fusesource.org/ */

import _root_.scala.collection.JavaConversions._
import _root_.org.fusesource.scalate.support.TemplateConversions._
import _root_.org.fusesource.scalate.util.Measurements._

object $_scalate_$next_jade {
  def $_scalate_$render($_scalate_$_context: _root_.org.fusesource.scalate.RenderContext): Unit = {
    import _root_.org.fusesource.scalate.support.RenderHelper.{sanitize=>$_scalate_$_sanitize, preserve=>$_scalate_$_preserve, indent=>$_scalate_$_indent, smart_sanitize=>$_scalate_$_smart_sanitize, attributes=>$_scalate_$_attributes}
    ;{
      val context: _root_.org.fusesource.scalate.RenderContext = $_scalate_$_context.attribute("context")
      import context._
      
      
      ;{
        val bookId: Seq[String] = $_scalate_$_context.attribute("bookId")
        ;{
          val bookName: Seq[String] = $_scalate_$_context.attribute("bookName")
          ;{
            val bookAuthor: Seq[String] = $_scalate_$_context.attribute("bookAuthor")
            $_scalate_$_context << ( "<span>\n  Trial Overview......Trial Overview......Trial Overview......Trial Overview......Trial Overview......Trial Overview......\n  HI " );
            $_scalate_$_context <<< (             bookId
 );
            $_scalate_$_context << ( "\n  " );
            $_scalate_$_context <<< (             bookName
 );
            $_scalate_$_context << ( "\n  " );
            $_scalate_$_context <<< (             bookAuthor
 );
            $_scalate_$_context << ( "\n</span>\n<span>\n  <br>\n    <!-- /= render(\"final.jade\", Map(\"Name\" -> Name)) -->\n  </br>\n  <br/>\n  <a title=\"Open Search Options\" href=\"/query-builder\">\n    Advanced Search\n  </a>\n</span>\n" );
          }
        }
      }
    }
  }
}


class $_scalate_$next_jade extends _root_.org.fusesource.scalate.Template {
  def render(context: _root_.org.fusesource.scalate.RenderContext): Unit = $_scalate_$next_jade.$_scalate_$render(context)
}