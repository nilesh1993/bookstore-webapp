package marklogic

/**
 * Created by njm1688 on 5/10/16.
 */

import com.marklogic.xcc._

class XccManager(cs: ContentSource) {

  private val session: Session = cs.newSession()
  private val request: AdhocQuery = session.newAdhocQuery(null)

  def execute(query: String) = {
    request.setQuery(query)
    session.submitRequest(request)
  }

  def executeToSingleString(query: String,  separator: String) = {
    val rs: ResultSequence = execute(query)
    val str: String = rs.asString(separator)
    rs.close()
    str
  }
}
