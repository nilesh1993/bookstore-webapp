(function() {
  var Updatecoffee;

  window.updatecoffee = Updatecoffee = (function() {
    function Updatecoffee() {}

    $(document).on('click', '#searchbttn', function() {
      return Updatecoffee.search();
    });

    $(document).on('click', '.udpateButton', function(e) {
      var bookAuthor, bookId, bookName, target, uri;
      target = e.target.id;
      uri = $("#foo_" + target.split("_")[1])[0].value;
      bookId = $("#bookId_" + target.split("_")[1])[0].value;
      bookName = $("#bookName_" + target.split("_")[1])[0].value;
      bookAuthor = $("#bookAuthor_" + target.split("_")[1])[0].value;
      console.log(bookAuthor);
      return Updatecoffee.update(uri, bookId, bookName, bookAuthor);
    });

    Updatecoffee.search = function() {
      var id, value;
      id = document.forms['updateForm']['BookId'].value;
      value = document.forms['updateForm']['mydropdown'].value;
      console.log("value----" + value);
      console.log("in search" + id);
      return jQuery.ajax({
        type: "GET",
        url: "/updateSearch/" + id + "/" + value,
        success: Updatecoffee.successCallback,
        error: Updatecoffee.failCallback,
        contentType: "application/json",
        dataType: "json"
      });
    };

    Updatecoffee.addSearchRequestData = function() {
      var data;
      data = {};
      data['mydropdown'] = document.forms['searchForm']['mydropdown'].value;
      data['BookId'] = document.forms['searchForm']['BookId'].value;
      return JSON.stringify(data);
    };

    Updatecoffee.successCallback = function(data) {
      return $('#serchData').html(data);
    };

    Updatecoffee.failCallback = function(data) {
      return $('#serchData').html(data.responseText);
    };

    Updatecoffee.update = function(uri, bookId, bookName, bookAuthor) {
      console.log("in update");
      return jQuery.ajax({
        type: "POST",
        url: "/updateBook",
        data: Updatecoffee.updateBookData(uri, bookId, bookName, bookAuthor),
        success: Updatecoffee.successCall,
        error: Updatecoffee.failCall,
        contentType: "application/json",
        dataType: "json"
      });
    };

    Updatecoffee.updateBookData = function(uri, bookId, bookName, bookAuthor) {
      var data;
      console.log('in updatebookdata');
      console.log(uri, bookId, bookName, bookAuthor);
      data = {};
      data['uri'] = uri;
      data['bookId'] = bookId;
      data['bookName'] = bookName;
      data['bookAuthor'] = bookAuthor;
      return JSON.stringify(data);
    };

    Updatecoffee.successCall = function() {
      return alert("updated successfully");
    };

    return Updatecoffee;

  })();

}).call(this);

//# sourceMappingURL=update.js.map
