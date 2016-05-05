(function() {
  var Updatecoffee;

  window.updatecoffee = Updatecoffee = (function() {
    function Updatecoffee() {}

    $(document).on('click', '#searchbttn', function() {
      return Updatecoffee.search();
    });

    $(document).on('click', '#updatebtn', function() {
      return Updatecoffee.update();
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

    Updatecoffee.update = function() {
      console.log("in update");
      return jQuery.ajax({
        type: "POST",
        url: "/updateBook",
        data: Updatecoffee.updateBookData(),
        success: Updatecoffee.successCall,
        error: Updatecoffee.failCall,
        contentType: "application/json",
        dataType: "json"
      });
    };

    Updatecoffee.updateBookData = function() {
      var data;
      console.log("in updatebookdata");
      data = {};
      data['dropdown'] = document.forms['updateFormm']['dropdown'].value;
      data['old'] = document.forms['updateFormm']['old'].value;
      data['new'] = document.forms['updateFormm']['new'].value;
      return JSON.stringify(data);
    };

    Updatecoffee.successCall = function() {
      return alert("updated successfully");
    };

    return Updatecoffee;

  })();

}).call(this);

//# sourceMappingURL=update.js.map
