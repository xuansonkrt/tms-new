//$.fn.datepicker.dates['vn'] = {
//        	    days:  ['Chủ nhật', 'Thứ 2', 'Thứ 3', 'Thứ 4', 'Thứ 5', 'Thứ 6', 'Thứ 7'],
//        	    daysShort: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
//        	    daysMin:  ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
//        	    months: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6'
//        			, 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10','Tháng 11', 'Tháng 12'],
//        	    monthsShort: ['T1', 'T2', 'T3', 'T4', 'T5', 'T6'
//        			, 'T7', 'T8', 'T9', 'T10','T11', 'T12'],
//        	    today: "Today",
//        	    clear: "Clear",
//        	    format: "dd/mm/yyyy",
//        	    weekStart: 0
//        	};

function ajaxUpdate(method,areaId,url,data,callback){
    $.ajax({
        url: url,
        data: data,
        type: method,
        dataType: "html",
        success: function (data) {
//            var result = $('<div />').append(data).find('#showresults').html();
            $('#'+areaId).html(data);
            callback();
        },
        error: function (xhr, status) {
            console.log("Sorry, there was a problem!");
        },
        complete: function (xhr, status) {
            //$('#showresults').slideDown('slow')
        }
    });
}


function ajaxSendData(method,areaId,url,data,callback){
    $.ajax({
        url: url,
        data: data,
        type: method,
        dataType: "html",
        success: function (data) {
//            var result = $('<div />').append(data).find('#showresults').html();
            $('#'+areaId).html(data);
            if(callback){
            	callback();
            }
            
        },
        error: function (xhr, status) {
            console.log("Sorry, there was a problem!");
        },
        complete: function (xhr, status) {
            //$('#showresults').slideDown('slow')
        }
    });
}


/**  
 * gets the contents of the form as a URL encoded String  
 * suitable for appending to a url  
 * @param formName to encode  
 * @return string with encoded form values , beings with &  
 */    
function getFormAsString(formName){   
      
   //Setup the return String   
   returnString ="";   
      
   //Get the form values   
   formElements=document.forms[formName].elements;   
      
   //loop through the array , building up the url   
   //in the form /strutsaction.do&name=value   
      
   for ( var i=formElements.length-1; i>=0; --i ){   
       //we escape (encode) each value   
       returnString=returnString+"&"+escape(formElements[i].name)+"="+escape(formElements[i].value);   
   }   
      
   //return the values   
   return returnString;    
}


function getFormData(formName){   
	   returnData ={};   
	   formElements=document.forms[formName].elements;   
	   for ( var i=formElements.length-1; i>=0; --i ){
		   if(formElements[i].name){
			   returnData[formElements[i].name]=formElements[i].value;
		   }
	   }   
	   return returnData;    
	}

function confirmDelete(mes){
	mes = mes ? "Bạn có muốn xóa dữ liệu?" : mes;
	swal({
        title: mes,
        text: "Bạn sẽ không có khả năng khôi phục!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '<i class="fa fa-trash"></i> Xóa',
        cancelButtonText:'<i class="fa fa-close"></i> Hủy bỏ'
    }).then(function(result)  {
        /*if (result.value) {
        	
        }*/
    	return result.value;
    });
}
function confirmSave(mes){
	mes = mes ? "Bạn có muốn lưu dữ liệu?" : mes;
	swal({
        title: mes,
//        text: "Bạn sẽ không có khả năng khôi phục!",
        type: 'info',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '<i class="fa fa-save"></i> Lưu lại',
        cancelButtonText:'<i class="fa fa-close"></i> Hủy bỏ'
    }).then(function(result)  {
        /*if (result.value) {
        	
        }*/
    	return result.value;
    });
}