function ajaxUpdate(method,areaId,url,data){
    $.ajax({
        url: url,
        data: data,
        type: method,
        dataType: "html",
        success: function (data) {
//            var result = $('<div />').append(data).find('#showresults').html();
            $('#'+areaId).html(data);
        },
        error: function (xhr, status) {
            console.log("Sorry, there was a problem!");
        },
        complete: function (xhr, status) {
            //$('#showresults').slideDown('slow')
        }
    });
} 