/**
<<<<<<< HEAD
=======
 * Created by kg on 01/08/2022.
 *//*


*/
/**
>>>>>>> 40453fb323c9efbc79ef7b51563df45bab05f778
 * Created by USER on 8/22/2019.
 *//*


trackApplication = (function () {
    var form = $('#trackApplicationFormId');

    function _baseURL() {
<<<<<<< HEAD
        return 'trackApplication/';
    }

    function getTrackApplicationDetail() {
        $('#btnView').on('click', function () {
            var applicationNo = $('#applicationNo').val();
            var url = _baseURL() + 'getTrackApplicationDetail';
=======
        return '/trackApplication/';
    }

    function getTrackApplicationDetailMC() {
            alert("");
            var applicationNo = $('#applicationNo').val();
            var url = _baseURL() + 'getTrackApplicationDetailMC/';
>>>>>>> 40453fb323c9efbc79ef7b51563df45bab05f778
            $.ajax({
                url: url
                , type: 'GET'
                , data: {applicationNo: applicationNo}
                , success: function (res) {
                    var data = res.responseDTO;
                    if (res.responseStatus == 1) {
                        $('#applicationDetailTableId').show();
                        $('#createdDate').text(formatAsDate(data.createdDate));
                        $('#serviceName').text(data.serviceName);
                        $('#statusName').text(data.statusName);
                        $('#courtName').text(data.courtName);
                        $('#appoinmentDate').text(data.hospitalName);
                        $('#appoinmentTime').text(data.appoinmentTime);
                    } else {
                        warningMsg(res.responseText);
                        $('#applicationNo').val();
                        $('#applicationDetailTableId').hide();
                        $('.field').text('');
                    }
                }
            });
<<<<<<< HEAD
        });
    }

    return {
        getTrackApplicationDetail: getTrackApplicationDetail
=======
    }

    //function getTrackApplicationDetailMC() {
    //    alert();
    //    $('#btnView').on('click', function () {
    //        var applicationNo = $('#applicationNo').val();
    //        var url = _baseURL() + 'getTrackApplicationDetailMC';
    //        $.ajax({
    //            url: url
    //            , type: 'GET'
    //            , data: {applicationNo: applicationNo}
    //            , success: function (res) {
    //                var data = res.responseDTO;
    //                if (res.responseStatus == 1) {
    //                    $('#applicationDetailTableId').show();
    //                    $('#createdDate').text(formatAsDate(data.createdDate));
    //                    $('#serviceName').text(data.serviceName);
    //                    $('#statusName').text(data.statusName);
    //                    $('#courtName').text(data.courtName);
    //                    $('#appoinmentDate').text(data.hospitalName);
    //                    $('#appoinmentTime').text(data.appoinmentTime);
    //                } else {
    //                    warningMsg(res.responseText);
    //                    $('#applicationNo').val();
    //                    $('#applicationDetailTableId').hide();
    //                    $('.field').text('');
    //                }
    //            }
    //        });
    //    });
    //}



    return {
      //  getTrackApplicationDetailAP: getTrackApplicationDetailAP,
        getTrackApplicationDetailMC: getTrackApplicationDetailMC
>>>>>>> 40453fb323c9efbc79ef7b51563df45bab05f778
    }
})
();
$(document).ready(
    function () {
<<<<<<< HEAD
        trackApplication.getTrackApplicationDetail();
=======
      //  trackApplication.getTrackApplicationDetailAP();
        trackApplication.getTrackApplicationDetailMC();
>>>>>>> 40453fb323c9efbc79ef7b51563df45bab05f778
    });


*/
