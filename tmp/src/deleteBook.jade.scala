/* NOTE this file is autogenerated by Scalate : see http://scalate.fusesource.org/ */

import _root_.scala.collection.JavaConversions._
import _root_.org.fusesource.scalate.support.TemplateConversions._
import _root_.org.fusesource.scalate.util.Measurements._

object $_scalate_$deleteBook_jade {
  def $_scalate_$render($_scalate_$_context: _root_.org.fusesource.scalate.RenderContext): Unit = {
    import _root_.org.fusesource.scalate.support.RenderHelper.{sanitize=>$_scalate_$_sanitize, preserve=>$_scalate_$_preserve, indent=>$_scalate_$_indent, smart_sanitize=>$_scalate_$_smart_sanitize, attributes=>$_scalate_$_attributes}
    ;{
      val context: _root_.org.fusesource.scalate.RenderContext = $_scalate_$_context.attribute("context")
      import context._
      
      
      $_scalate_$_context << ( "<head>\n  <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n</head>\n<form action=\"deleteData\" method=\"post\" id=\"deleteForm\">\n  <select name=\"mydropdown\">\n    <option value=\"bookId\">bookId</option>\n    <option value=\"bookName\">bookName</option>\n    <option value=\"bookAuthor\">bookAuthor</option>\n    <input type=\"text\" name=\"BookId\"/>\n    <br/>\n  </select>\n  <input type=\"button\" id=\"deletebutton\" class=\"deletebutton\" value=\"Delete\"/>\n</form>\n" );
    }
  }
}


class $_scalate_$deleteBook_jade extends _root_.org.fusesource.scalate.Template {
  def render(context: _root_.org.fusesource.scalate.RenderContext): Unit = $_scalate_$deleteBook_jade.$_scalate_$render(context)
}
