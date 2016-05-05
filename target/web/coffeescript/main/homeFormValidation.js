(function() {
  var Coffeecup;

  window.coffeecup = Coffeecup = (function() {
    function Coffeecup() {}

    Coffeecup.validate = function() {
      var x, y, z;
      x = document.forms['myForm']['BookId'].value;
      y = document.forms['myForm']['BookName'].value;
      z = document.forms['myForm']['BookAuthor'].value;
      if (x === '' && y === '' && z === '') {
        alert('please fill all the fields');
        return false;
      } else if (x === null || x === '') {
        alert('Id must be filled out');
        return false;
      } else if (y === null || y === '') {
        alert('Name must be filled out');
        return false;
      } else if (z === null || z === '') {
        alert('Author name must be filled out');
        return false;
      }
      return Coffeecup.add();
    };

    $(document).on('click', '#iAmGoodBtn', function() {
      return Coffeecup.validate();
    });

    Coffeecup.add = function() {
      console.log("hiiiiii");
      return jQuery.ajax({
        type: "POST",
        url: "/addBook",
        data: Coffeecup.addBookRequestData(),
        success: Coffeecup.successCallback,
        error: Coffeecup.failCallback,
        contentType: "application/json",
        dataType: "json"
      });
    };

    Coffeecup.addBookRequestData = function() {
      var data;
      data = {};
      data['BookId'] = document.forms['myForm']['BookId'].value;
      data['BookName'] = document.forms['myForm']['BookName'].value;
      data['BookAuthor'] = document.forms['myForm']['BookAuthor'].value;
      return JSON.stringify(data);
    };

    Coffeecup.successCallback = function(data) {
      return alert("bookID-" + data.BookId + "    BookName-" + data.BookName + "   BookAuthor-" + data.BookAuthor + "    This Book is successfully added");
    };

    return Coffeecup;

  })();

}).call(this);

//# sourceMappingURL=homeFormValidation.js.map
