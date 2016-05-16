(function() {
  var DeleteCoffee;

  window.deleteCoffee = DeleteCoffee = (function() {
    function DeleteCoffee() {}

    $(document).on('click', '.deletebutton', function(e) {
      var num, target, uri;
      console.log('m being called');
      target = e.target.id;
      num = target.split("_")[1];
      uri = $("#foo_" + target.split("_")[1])[0].value;
      return DeleteCoffee["delete"](uri);
    });

    DeleteCoffee["delete"] = function(uri) {
      return jQuery.ajax({
        type: "POST",
        url: "/deleteBook",
        data: DeleteCoffee.deleteRequestData(uri),
        success: DeleteCoffee.successCallback,
        error: DeleteCoffee.failCallback,
        contentType: "application/json",
        dataType: "json"
      });
    };

    DeleteCoffee.deleteRequestData = function(uri) {
      return JSON.stringify(uri);
    };

    DeleteCoffee.successCallback = function() {
      return alert("successFully Deleted");
    };

    return DeleteCoffee;

  })();

}).call(this);

//# sourceMappingURL=delete.js.map
