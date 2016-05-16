window.deleteCoffee = class DeleteCoffee

	$(document).on 'click', '.deletebutton', (e) =>
		console.log 'm being called'
		target = e.target.id
		num = target.split("_")[1]
		uri = $("#foo_"+target.split("_")[1])[0].value

		@delete(uri)

	@delete:(uri) =>
		jQuery.ajax({
				type:"POST",
				url:"/deleteBook",
				data: @deleteRequestData(uri)
				success: @successCallback,
				error: @failCallback
				contentType: "application/json"
				dataType: "json"
			})

	@deleteRequestData:(uri) =>
		#console.log(uri)
		#data = {}
		JSON.stringify(uri)

	@successCallback: =>
		alert("successFully Deleted")