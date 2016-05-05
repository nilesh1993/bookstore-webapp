// @SOURCE:/Users/njm1688/MyProjects/NewProjectRender/conf/routes
// @HASH:62e9cb7884370ebf915760589a6dec98668571f2
// @DATE:Thu May 05 10:42:40 IST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:38
// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:22
// @LINE:20
// @LINE:16
// @LINE:14
// @LINE:11
// @LINE:9
// @LINE:6
package controllers {

// @LINE:38
class ReverseAssets {


// @LINE:38
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          

// @LINE:16
// @LINE:14
class Reversedelete {


// @LINE:16
def deleteBook(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "deleteBook")
}
                        

// @LINE:14
def renderDeletePage(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "deleteBook")
}
                        

}
                          

// @LINE:30
// @LINE:26
class Reverseupdate {


// @LINE:30
def update(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "updateBook")
}
                        

// @LINE:26
def renderUpdatePage(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "updateBook")
}
                        

}
                          

// @LINE:11
// @LINE:9
class Reverseadd {


// @LINE:9
def renderAddPage(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "addBook")
}
                        

// @LINE:11
def addBook(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "addBook")
}
                        

}
                          

// @LINE:28
// @LINE:22
// @LINE:20
class Reversesearch {


// @LINE:20
def renderSearchPage(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "searchBook")
}
                        

// @LINE:28
// @LINE:22
def searchBook(id:String, value:String): Call = {
   (id: @unchecked, value: @unchecked) match {
// @LINE:22
case (id, value)  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "searchBook/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/" + implicitly[PathBindable[String]].unbind("value", dynamicString(value)))
                                         
   }
}
                                                

}
                          
}
                  


// @LINE:38
// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:22
// @LINE:20
// @LINE:16
// @LINE:14
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:38
class ReverseAssets {


// @LINE:38
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:6
class ReverseApplication {


// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              

// @LINE:16
// @LINE:14
class Reversedelete {


// @LINE:16
def deleteBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delete.deleteBook",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteBook"})
      }
   """
)
                        

// @LINE:14
def renderDeletePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delete.renderDeletePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteBook"})
      }
   """
)
                        

}
              

// @LINE:30
// @LINE:26
class Reverseupdate {


// @LINE:30
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.update.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateBook"})
      }
   """
)
                        

// @LINE:26
def renderUpdatePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.update.renderUpdatePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updateBook"})
      }
   """
)
                        

}
              

// @LINE:11
// @LINE:9
class Reverseadd {


// @LINE:9
def renderAddPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.add.renderAddPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addBook"})
      }
   """
)
                        

// @LINE:11
def addBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.add.addBook",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBook"})
      }
   """
)
                        

}
              

// @LINE:28
// @LINE:22
// @LINE:20
class Reversesearch {


// @LINE:20
def renderSearchPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.search.renderSearchPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchBook"})
      }
   """
)
                        

// @LINE:28
// @LINE:22
def searchBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.search.searchBook",
   """
      function(id, value) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchBook/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("value", encodeURIComponent(value))})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updateSearch/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("value", encodeURIComponent(value))})
      }
      }
   """
)
                        

}
              
}
        


// @LINE:38
// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:22
// @LINE:20
// @LINE:16
// @LINE:14
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:38
class ReverseAssets {


// @LINE:38
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          

// @LINE:16
// @LINE:14
class Reversedelete {


// @LINE:16
def deleteBook(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delete.deleteBook(), HandlerDef(this.getClass.getClassLoader, "", "controllers.delete", "deleteBook", Seq(), "POST", """""", _prefix + """deleteBook""")
)
                      

// @LINE:14
def renderDeletePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delete.renderDeletePage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.delete", "renderDeletePage", Seq(), "GET", """""", _prefix + """deleteBook""")
)
                      

}
                          

// @LINE:30
// @LINE:26
class Reverseupdate {


// @LINE:30
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.update.update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.update", "update", Seq(), "POST", """""", _prefix + """updateBook""")
)
                      

// @LINE:26
def renderUpdatePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.update.renderUpdatePage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.update", "renderUpdatePage", Seq(), "GET", """""", _prefix + """updateBook""")
)
                      

}
                          

// @LINE:11
// @LINE:9
class Reverseadd {


// @LINE:9
def renderAddPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.add.renderAddPage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.add", "renderAddPage", Seq(), "GET", """""", _prefix + """addBook""")
)
                      

// @LINE:11
def addBook(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.add.addBook(), HandlerDef(this.getClass.getClassLoader, "", "controllers.add", "addBook", Seq(), "POST", """""", _prefix + """addBook""")
)
                      

}
                          

// @LINE:28
// @LINE:22
// @LINE:20
class Reversesearch {


// @LINE:20
def renderSearchPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.search.renderSearchPage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.search", "renderSearchPage", Seq(), "GET", """""", _prefix + """searchBook""")
)
                      

// @LINE:22
def searchBook(id:String, value:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.search.searchBook(id, value), HandlerDef(this.getClass.getClassLoader, "", "controllers.search", "searchBook", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """searchBook/$id<[^/]+>/$value<[^/]+>""")
)
                      

}
                          
}
        
    