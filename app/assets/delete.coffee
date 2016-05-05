window.deleteCoffee = class DeleteCoffee


	$(document).on 'click', '#deletebutton', =>
		@delete()

	@delete: =>
		console.log("in search")
		jQuery.ajax({
				type:"POST",
				url:"/deleteBook",
				data: @deleteRequestData()
				success: @successCallback,
				error: @failCallback
				contentType: "application/json"
				dataType: "json"
			})

	@deleteRequestData: =>
		console.log("in deleterequestdata")
		data = {}
		data['BookId'] = document.forms['deleteForm']['BookId'].value
		data['mydropdown'] = document.forms['deleteForm']['mydropdown'].value
		JSON.stringify(data)
		#console.log(data['mydropdown'],data['BookId'])

	@successCallback: =>
		alert("successFully Deleted")