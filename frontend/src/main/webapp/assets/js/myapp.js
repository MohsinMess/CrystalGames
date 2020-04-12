$(function() {
	// code for Jquery datatable

	
	var $table=$('#productListTable');
	
	//execute the below code only when we have this table
	if($table.length)
		{
		 	 //console.log('Inside the table');
			
			var jsonUrl='';
			if(window.categoryid ==''){
				jsonUrl=window.contextRoot+'/json/data/all/products';
			}
			else{
				jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryid+'/products';
			}
				
		
			$table.DataTable({
				lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
				pageLength: 5,
				
				
				// To pass data in the form of json to the web page
				ajax:{
					url: jsonUrl,
					dataSrc:''
				},
				columns:[
					{
						data:'code',
						mRender: function(data,type,row){
							return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';	
						}
					},
					{
						data:'name'
					},
					{
						data:'brand'
					},
					{
						data:'unit_price',
						mRender: function(data,type,row){	
							return'&#8377; ' + data
						}
					},
					{
						data:'quantity'
					},
					{
						data:'id',
						mRender: function(data,type,row){
							 
							var str1 = '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>';
							var str2 = '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success">BUY</a>';
							return str1 + str2;
						}
					}
				]
			})
		}	
	
	// dismissing the alert after 3 secs
	var $alert= $('alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
			},3000)
			
	}
	
	
	
});