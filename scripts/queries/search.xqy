

let $searchTerm := xdmp:get-request-field("searchTerm")
let $searchValue := xdmp:get-request-field("searchValue")


(:let $x := cts:search(//bookName,
        cts:element-value-query(
                xs:QName("bookName"),
                concat($searchValue,"*"), "wildcarded"))

return cts:search(//book, cts:element-range-query(xs:QName("bookName"), "=", xs:string($x/text()))):)


let $results := cts:search(//book,
        cts:element-word-query(
                xs:QName($searchTerm),
                concat($searchValue,"*"), "wildcarded"))

return <results>
        {
                for $result in $results
                       return <result><uri>{xdmp:node-uri($result)}</uri>{$result}</result>
        }
        </results>