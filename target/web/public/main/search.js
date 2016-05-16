(function() {
  var SearchCoffee;

  window.searchCoffee = SearchCoffee = (function() {
    function SearchCoffee() {}

    $(document).on('click', '#searchbtn', function() {
      return SearchCoffee.search();
    });

    SearchCoffee.search = function() {
      var id, value;
      id = document.forms['searchForm']['BookId'].value;
      value = document.forms['searchForm']['mydropdown'].value;
      console.log("value----" + value);
      console.log("in search");
      return jQuery.ajax({
        type: "GET",
        url: "/searchBook/" + id + "/" + value,
        success: SearchCoffee.successCallback,
        error: SearchCoffee.failCallback
      });
    };

    SearchCoffee.addSearchRequestData = function() {
      var data;
      data = {};
      data['mydropdown'] = document.forms['searchForm']['mydropdown'].value;
      data['BookId'] = document.forms['searchForm']['BookId'].value;
      return JSON.stringify(data);
    };

    SearchCoffee.successCallback = function(responseData) {
      console.log("responseData : ", responseData);
      return $("#printResult").html(responseData);
    };

    SearchCoffee.failCallback = function(data) {
      return $('#serchData').html(data.responseText);
    };

    return SearchCoffee;

  })();

}).call(this);

//# sourceMappingURL=search.js.map
