window.coffeecup = class Coffeecup

   # alert("in alert ------")
	#$('#iAmGoodBtn').on 'click', ->
	#    console.log "hiiiii"
	#    validate()
	@validate: =>
		x = document.forms['myForm']['BookId'].value
		y = document.forms['myForm']['BookName'].value
		z = document.forms['myForm']['BookAuthor'].value
		#console.log x
		if x == '' and y == '' and z == ''
			alert 'please fill all the fields'
			return false
		else if x == null or x == ''
			alert 'Id must be filled out'
			return false
		else if y == null or y == ''
			alert 'Name must be filled out'
			return false
		else if z == null or z == ''
			alert 'Author name must be filled out'
			return false

		@add()


	$(document).on 'click', '#iAmGoodBtn', =>
		#console.log("hi")
		@validate()

	@add: =>
		console.log "hiiiiii"
		jQuery.ajax({
				type:"POST",
				url:"/addBook",
				data: @addBookRequestData()
				success: @successCallback,
				error: @failCallback
				contentType: "application/json"
				dataType: "json"
			})

	@addBookRequestData: ->
		#console.log "in addbookdata"
		data = {}
		data['BookId'] = document.forms['myForm']['BookId'].value
		data['BookName'] = document.forms['myForm']['BookName'].value
		data['BookAuthor'] = document.forms['myForm']['BookAuthor'].value
		#console.log(data['BookId'],data['BookName'])
		JSON.stringify(data)

	@successCallback:(data) =>
		#console.log "in success"
		alert ("bookID-"+data.BookId+ "    BookName-"+data.BookName+ "   BookAuthor-"+data.BookAuthor+"    This Book is successfully added")
