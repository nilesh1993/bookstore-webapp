xquery version "1.0-ml";

import module namespace info = "http://marklogic.com/appservices/infostudio" at "/MarkLogic/appservices/infostudio/info.xqy";

declare variable $MODULES_DB as xs:string := "book-modules";
declare variable $CONTENT_DB as xs:string := "book";

declare function local:initial-db-check($dbname as xs:string) as xs:unsignedLong? {
    for $db in xdmp:databases()
    where xdmp:database-name($db) eq $dbname
    return $db
};

declare function local:check-and-create-database($dbname as xs:string) as xs:unsignedLong?
{
    if (local:initial-db-check($dbname) gt 0) then
        (xdmp:log(concat($dbname," already exists, ignoring create command")))
    else (info:database-create($dbname))
};

(
    local:check-and-create-database($CONTENT_DB),
    local:check-and-create-database($MODULES_DB)
)