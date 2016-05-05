package controllers



import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy
import org.fusesource.scalate.util.FileResourceLoader
import play.api.Play
import play.api.Play.current
import play.twirl.api.Html

/**
 * Created by njm1688 on 4/11/16.
 */
class JadeRenderer(scalateEngine: TemplateEngine) {

  def render(templateName: String, args: (String, Any)*): Html = {
    val paramMap = args.toMap + (("buildVersion", 0.1), ("includeMinifiedAssets", false))

    if(Play.isDev) {
      val old = Thread.currentThread().getContextClassLoader
      println("paramMap"+paramMap)
      try{
        Thread.currentThread().setContextClassLoader(Play.application.classloader)
        println("templateName"+templateName)
        Html(scalateEngine.layout(templateFile(templateName), paramMap))
      } finally {
        Thread.currentThread().setContextClassLoader(old)
      }
    } else {
      val template: String = templateFile(templateName)
      val layout: String = scalateEngine.layout(template, paramMap)
      println("layout ----- "+layout)
      Html(layout)
    }

  }

  private def templateFile(name: String): String = {
    s"$name.jade"
  }
}

object JadeRenderer {

  def apply(template: String)= {
    new JadeRenderer(scalateEngine(template))
  }

  private def scalateEngine(withLayoutStrategy: String)= {
    val engine = new TemplateEngine
    engine.resourceLoader = new FileResourceLoader(Some(Play.getFile("app/views")))
    engine.layoutStrategy = new DefaultLayoutStrategy(engine, withLayoutStrategy)
    engine.classpath = "tmp/classes"
    engine.workingDirectory = Play.getFile("tmp")
    engine.combinedClassPath = true
    engine.escapeMarkup = true
    engine.classLoader = Play.classloader
    engine
  }
}

