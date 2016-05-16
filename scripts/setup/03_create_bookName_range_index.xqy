xquery version "1.0-ml";

import module namespace admin = "http://marklogic.com/xdmp/admin" at "/MarkLogic/admin.xqy";

let $config := admin:get-configuration()
let $dbid := xdmp:database("book")
let $drug_rangespec :=
    admin:database-range-element-index(
            "string", "http://www.w3.org/1999/xhtml",
            "bookName", "http://marklogic.com/collation/",
            fn:false()
    )
let $config := admin:database-add-range-element-index($config, $dbid, $drug_rangespec)
return admin:save-configuration($config)