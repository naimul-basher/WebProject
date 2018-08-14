/**
 * 
 */
	$(document).ready(function () {
		
		//var phone_digit = phone.substring(1, phone.length-1);
	    
		$('#myform').validate({ // initialize the plugin
	        rules: {
	            firstname: {
	                required: true,
	                minlength: 6
	            },
	            lastname: {
	                required: true,
	                minlength: 6
	            },
	            username: {
	                required: true,
	                rangelength: [5, 8]
	            },
	        	address: {
	                required: true,
	                minlength: 5
	            },
	        	phone: {
	                required: true,
	                minlength: 5
	            },
	            phone_digit: {
	            	digits: true
	            },
	        	email: {
	                required: true,
	                email: true
	            },
	        	password: {
	                required: true,
	                minlegth: 5
	            }
	        }
	    });
	
	});
