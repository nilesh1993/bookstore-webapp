/* NOTE this file is autogenerated by Scalate : see http://scalate.fusesource.org/ */

import _root_.scala.collection.JavaConversions._
import _root_.org.fusesource.scalate.support.TemplateConversions._
import _root_.org.fusesource.scalate.util.Measurements._

object $_scalate_$default_jade {
  def $_scalate_$render($_scalate_$_context: _root_.org.fusesource.scalate.RenderContext): Unit = {
    import _root_.org.fusesource.scalate.support.RenderHelper.{sanitize=>$_scalate_$_sanitize, preserve=>$_scalate_$_preserve, indent=>$_scalate_$_indent, smart_sanitize=>$_scalate_$_smart_sanitize, attributes=>$_scalate_$_attributes}
    ;{
      val context: _root_.org.fusesource.scalate.RenderContext = $_scalate_$_context.attribute("context")
      import context._
      
      
      ;{
        val body: String = $_scalate_$_context.attribute("body")
        $_scalate_$_context << ( "<head>\n  <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n  <script type=\"text/javascript\" src=\"/assets/search.js\"></script>\n  <script type=\"text/javascript\" src=\"/assets/homeFormValidation.js\"></script>\n</head>\n<body>\n  " );
        $_scalate_$_context << ( $_scalate_$_indent ( "  ", $_scalate_$_context.value(
           unescape(body)
        ) ) );
        $_scalate_$_context << ( "\n</body>\n" );
      }
    }
  }
}


class $_scalate_$default_jade extends _root_.org.fusesource.scalate.Template {
  def render(context: _root_.org.fusesource.scalate.RenderContext): Unit = $_scalate_$default_jade.$_scalate_$render(context)
}
