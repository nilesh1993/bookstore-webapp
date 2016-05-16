window.searchCoffee = class SearchCoffee

	#alert('hello')
	$(document).on 'click', '#searchbtn', =>
		@search()

	@search: =>
		id = document.forms['searchForm']['BookId'].value
		value = document.forms['searchForm']['mydropdown'].value
		console.log("value----"+ value)
		console.log("in search")
		jQuery.ajax({
				type:"GET",
				url:"/searchBook/"+id+"/"+value,
				#data: @addSearchRequestData()
				success: @successCallback,
				error: @failCallback
			})

	@addSearchRequestData: =>
		data = {}
		data['mydropdown']= document.forms['searchForm']['mydropdown'].value
		data['BookId']= document.forms['searchForm']['BookId'].value
		JSON.stringify(data)
		#console.log(data['mydropdown'],data['BookId'])

	@successCallback: (responseData)=>
		console.log("responseData : ", responseData)
		$("#printResult").html(responseData)


	@failCallback: (data)=>
		$( '#serchData' ).html(data.responseText)