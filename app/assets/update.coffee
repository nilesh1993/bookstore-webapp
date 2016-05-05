window.updatecoffee = class Updatecoffee


	$(document).on 'click', '#searchbttn', =>
		@search()

	$(document).on 'click', '#updatebtn', =>
		@update()

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

	@update: =>
		console.log("in update")
		jQuery.ajax({
				type:"POST",
				url:"/updateBook",
				data: @updateBookData()
				success: @successCall,
				error: @failCall
				contentType: "application/json"
				dataType: "json"
			})

	@updateBookData: =>
		console.log("in updatebookdata")
		data = {}
		data['dropdown']= document.forms['updateFormm']['dropdown'].value
		data['old']= document.forms['updateFormm']['old'].value
		data['new']= document.forms['updateFormm']['new'].value
		JSON.stringify(data)
		#console.log(data['mydropdown'],data['BookId'])

	@successCall: =>
		alert("updated successfully")
