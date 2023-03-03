$(document).ready(function () {
    if (document.URL.search("notaryTaskList") > 1)
        scriptLoader("/resources/js/judiciary/notaryTaskList.js");
    if (document.URL.search("paymentDetail") > 1)
        scriptLoader("/resources/js/judiciary/paymentDetail.js");
    if (document.URL.search("dataManagerTaskList") > 1)
        scriptLoader("/resources/js/judiciary/dataManagerTaskList.js");
    if (document.URL.search("printCertificate") > 1)
        scriptLoader("/resources/js/judiciary/printCertificate.js");
});

var scriptLoader = function (url) {
     url = '/resources/js/' + url + '.js';
    //url = window.location.protocol + '//' + window.location.host + '/judiciary' + url;
    //url = window.location.protocol + '//' + window.location.host + '/' + url;
<<<<<<< HEAD
   //url =  '/' + url;
=======
   url =  '/' + url;
>>>>>>> 40453fb323c9efbc79ef7b51563df45bab05f778
    $.ajax(
        {
            type: "GET",
            url: url,
            dataType: "script",
            cache: false
        });
};
