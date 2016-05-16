
let $xmlName := xdmp:get-request-field("deleteData")

return
xdmp:document-delete($xmlName)