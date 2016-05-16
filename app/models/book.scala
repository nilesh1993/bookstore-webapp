package models

import play.api.libs.json._

/**
 * Created by njm1688 on 5/12/16.
 */
case class book(uri:String,bookId:String,bookName:String,bookAuthor:String)



//object book {
//  implicit object TweetFormat extends Format[book] {
//
//    def writes(bookObj : book) : JsValue = {
//      val books = Seq(
//      "uri" -> JsString(bookObj.uri),
//      "bookId" -> JsString(bookObj.bookId),
//      "bookName" -> JsString(bookObj.bookName),
//      "bookAuthor" -> JsString(bookObj.bookAuthor)
//
//      )
//      JsObject(books)
//    }
//  }
//}


/*    def getseq(listOfbook:Seq[book]): JsObject = {


      println("getseq------------" + JsObject(tweetSeq))

    }*/