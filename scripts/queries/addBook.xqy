
let $xmlName := xdmp:get-request-field("nextXml")
let $bookId := xdmp:get-request-field("bookId")
let $bookName := xdmp:get-request-field("bookName")
let $bookAuthor := xdmp:get-request-field("bookAuthor")
let $fileName := concat("/catalog/", $xmlName, ".xml")

return
xdmp:document-insert($fileName,
<BookStore>
    <book>
    <bookId>{$bookId}</bookId>
    <bookName>{$bookName}</bookName>
    <bookAuthor>{$bookAuthor}</bookAuthor>
    </book>
</BookStore>)







