package services

import java.io.File
import java.net.URI
import java.util
import javax.transaction.Transaction

import com.marklogic.xcc._
import com.marklogic.xcc.exceptions.XQueryException
import marklogic.XccManager
import org.apache.commons.io.FileUtils
import play.Logger


class MarklogicService (xccUrl: String, databaseName: String, databaseModuleName: String) {

  val URI_PREFIX = "/book/"
  val NAMESPACE_PREFIX = "http://www.marklogic.com/book/"
  val contentSource = ContentSourceFactory.newContentSource(new URI(xccUrl))

  def execXquery(xqy: String)  {
    val xccManager = new XccManager(contentSource)
    val initialQuery = readFile(xqy)
    Logger.debug("executing xquery:: "+xqy)
    xccManager.executeToSingleString(initialQuery, System.getProperty("line.separator"))
  }

  def readFile(xqy: String) = {
    val testFile: File = new File(xqy)
    FileUtils.readFileToString(testFile)
  }

  /*
  TODO: iterate over xquery files and call execQuery for each one...remove toArray logic
   */
  def exec(dir: String) {
    val extension = Array("xqy")
    val xqueryFiles: util.Collection[File] = FileUtils.listFiles(new File(dir), extension, false)
    val itr: util.Iterator[File] = xqueryFiles.iterator()
    while(itr.hasNext) {
      val fileName = itr.next().getAbsolutePath
      println("itr.next : ", fileName)
      try {
        println("in execute")
        execXquery(fileName)
      } catch {
        case e : XQueryException => println("Failed to execute query ", fileName)
        case default => println("default exception for ", fileName)

      }

    }

  }

  def newContent(uri: String, data: Array[Byte], namespace: String): Content = {
    val cco = new ContentCreateOptions()
    cco.setNamespace(namespace)
    val cpArr = Array[ContentPermission](
      new ContentPermission(ContentCapability.READ, "rest-reader"),
      new ContentPermission(ContentCapability.EXECUTE, "rest-reader")
    )
    cco.setPermissions(cpArr)
    ContentFactory.newContent(uri, data, cco)
  }


  def loadDirectory(dir: String) {
    val extension = Array("xqy")
    val xqueryFiles: util.Collection[File] = FileUtils.listFiles(new File(dir), extension, false)
    val itr: util.Iterator[File] = xqueryFiles.iterator()
    while(itr.hasNext) {
      val name: File = itr.next()
      val contentString : String = readFile(name.getAbsolutePath)
      val content = newContent("/"+name.getName, contentString.getBytes, NAMESPACE_PREFIX)
      val contentArray: Array[Content] = Array(content)
      println("calling load for ", name)
      load(contentArray)
    }
  }

  def load(contents: Array[Content]) {
    val session = contentSource.newSession(databaseModuleName)
    session.insertContent(contents)
    session.close()
  }
}
