xquery version "1.0-ml";
import module namespace admin = "http://marklogic.com/xdmp/admin"
at "/MarkLogic/admin.xqy";

let $config := admin:get-configuration()
let $group-id := admin:group-get-id($config, "Default")
let $appserver-name := "bookHTTP"
let $root-dir := "/"
let $modules-db := admin:database-get-id($config, "book-modules")
let $content-db := admin:database-get-id($config, "book")
let $service-port := 8004

let $config := admin:http-server-create($config, $group-id, $appserver-name, "/", $service-port, $modules-db, $content-db)

let $appserver-id := admin:appserver-get-id($config, $group-id, $appserver-name)

let $config := admin:appserver-set-url-rewriter($config, $appserver-id, "/MarkLogic/rest-api/rewriter.xqy")
let $config := admin:appserver-set-error-handler($config,$appserver-id, "/MarkLogic/rest-api/error-handler.xqy")
let $config := admin:appserver-set-authentication($config, $appserver-id, "digest")
let $config := admin:appserver-set-log-errors($config, $appserver-id, false())
let $config := admin:appserver-set-rewrite-resolves-globally($config, $appserver-id, true())

return admin:save-configuration($config);