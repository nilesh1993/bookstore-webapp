window.updatecoffee = class Updatecoffee


	$(document).on 'click', '#searchbttn', =>
		@search()

	$(document).on 'click', '.udpateButton', (e) =>
		target = e.target.id
		uri = $("#foo_"+target.split("_")[1])[0].value
		bookId= $("#bookId_"+target.split("_")[1])[0].value
		bookName= $("#bookName_"+target.split("_")[1])[0].value
		bookAuthor= $("#bookAuthor_"+target.split("_")[1])[0].value
		console.log(bookAuthor)
		@update(uri,bookId,bookName,bookAuthor)

	@search: =>
		id = document.forms['updateForm']['BookId'].value
		value = document.forms['updateForm']['mydropdown'].value
		#alert('hello')
		console.log("value----"+ value)
		console.log("in search"+id)
		jQuery.ajax({
				type:"GET",
				url:"/updateSearch/"+id+"/"+value,
				#data: @addSearchRequestData()
				success: @successCallback,
				error: @failCallback
				contentType: "application/json"
				dataType: "json"
			})

	@addSearchRequestData: =>
		data = {}
		data['mydropdown']= document.forms['searchForm']['mydropdown'].value
		data['BookId']= document.forms['searchForm']['BookId'].value
		JSON.stringify(data)
		#console.log(data['mydropdown'],data['BookId'])

	@successCallback: (data)=>
		$( '#serchData' ).html(data)

	@failCallback: (data)=>
		$( '#serchData' ).html(data.responseText)

	@update:(uri,bookId,bookName,bookAuthor) =>
		console.log("in update")
		jQuery.ajax({
				type:"POST",
				url:"/updateBook",
				data: @updateBookData(uri,bookId,bookName,bookAuthor)
				success: @successCall,
				error: @failCall
				contentType: "application/json"
				dataType: "json"
			})

	@updateBookData:(uri,bookId,bookName,bookAuthor) =>
		console.log('in updatebookdata')
		console.log(uri,bookId,bookName,bookAuthor)
		data = {}
		data['uri']= uri
		data['bookId']= bookId
		data['bookName']= bookName
		data['bookAuthor']= bookAuthor
		JSON.stringify(data)
		#console.log(data['mydropdown'],data['BookId'])

	@successCall: =>
		alert("updated successfully")
