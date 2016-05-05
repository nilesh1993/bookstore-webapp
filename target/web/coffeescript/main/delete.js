(function() {
  var DeleteCoffee;

  window.deleteCoffee = DeleteCoffee = (function() {
    function DeleteCoffee() {}

    $(document).on('click', '#deletebutton', function() {
      return DeleteCoffee["delete"]();
    });

    DeleteCoffee["delete"] = function() {
      console.log("in search");
      return jQuery.ajax({
        type: "POST",
        url: "/deleteBook",
        data: DeleteCoffee.deleteRequestData(),
        success: DeleteCoffee.successCallback,
        error: DeleteCoffee.failCallback,
        contentType: "application/json",
        dataType: "json"
      });
    };

    DeleteCoffee.deleteRequestData = function() {
      var data;
      console.log("in deleterequestdata");
      data = {};
      data['BookId'] = document.forms['deleteForm']['BookId'].value;
      data['mydropdown'] = document.forms['deleteForm']['mydropdown'].value;
      return JSON.stringify(data);
    };

    DeleteCoffee.successCallback = function() {
      return alert("successFully Deleted");
    };

    return DeleteCoffee;

  })();

}).call(this);

//# sourceMappingURL=delete.js.map
