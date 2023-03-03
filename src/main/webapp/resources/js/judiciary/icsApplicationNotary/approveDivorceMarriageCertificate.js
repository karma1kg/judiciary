/**
 * Created by kg on 9/6/2022.
 */

approveDivorceMarriageCertificate = (function () {
    var form = $('#approveDivorceMarriageCertificateFormId');

    function _baseURL() {
        return 'approveDivorceMarriageCertificate/';
    }

    function disableTabs() {
        $('#personalDetails').prop('class', 'active');
        $('#personalDetails').not('.active').addClass('disabled');
        $('#personalDetailTab').prop('class', 'tab-pane active');

        $("#personalDetailTabId").css("color", "white");
        $("#personalDetailTabId").css("background-color", "rgb(18, 18, 19)");

        $('#documentSelection').not('.active').addClass('disabled');
        $('#documentSelection').not('.active').find('a').removeAttr("data-toggle");

        $('#otherInformation').not('.active').addClass('disabled');
        $('#otherInformation').not('.active').find('a').removeAttr("data-toggle");
    }

    function getApplicationDetail() {
        var applicationNo = $('#applicationNo').val();
        var url = _baseURL() + 'getApplicationDetail';
        $.ajax({
            url: url
            , type: 'GET'
            , data: {applicationNo: applicationNo}
            , success: function (res) {
                var data = res.responseDTO;
                var data1 = res.spouseDTO;
                var data5 = res.applicantDTO;
                if (res.responseStatus == 1) {
                    populate(data);
                    populate(data1);
                    populate(data5);
                    $('.field-readonly').prop('disabled', true);
                }
            }
        });
    }

    function btnNext() {
        $('#btnNext_1').on('click', function () {
            $('#documentSelectionTab').prop('class', 'tab-pane active');
            $('#personalDetails').removeClass("active");
            $('#personalDetailTab').removeClass("active");
            $("#personalDetailTabId").css("color", "white");
            $('#personalDetailsCheck').html('<i class="fa fa-check text-white"></i>');
            $("#personalDetailTabId").css("background-color", "#120f65");
            $("#documentSelectionTabId").css("background-color", "rgb(18, 18, 19)");
            $("#documentSelectionTabId").css("color", "white");

            $('#personalDetails').addClass('disabled');
        });
        $('#btnNext_2').on('click', function () {
            $('#otherInformationTab').prop('class', 'tab-pane active');
            $('#documentSelection').removeClass("active");
            $('#documentSelectionTab').removeClass("active");
            $('#documentSelectionCheck').html('<i class="fa fa-check text-white"></i>');
            $("#personalDetailTabId").css("color", "white");
            $("#personalDetailTabId").css("background-color", "#120f65");
            $("#documentSelectionTabId").css("background-color", "#120f65");
            $("#otherInformation").css("background-color", "rgb(18, 18, 19)");
            $("#otherInformation").css("color", "white");
        });
    }

    function btnPrevious() {
        $('#btnPrevious_1').on('click', function () {
            $('#personalDetailTab').prop('class', 'tab-pane active');
            $('#documentSelection').removeClass("active");
            $('#documentSelectionTab').removeClass("active");
            $("#personalDetailTabId").css("background-color", "rgb(18, 18, 19)");
            $("#documentSelectionTabId").css("background-color", "#120f65");
        });

        $('#btnPrevious_2').on('click', function () {
            $('#documentSelectionTab').prop('class', 'tab-pane active');
            $('#otherInformation').removeClass("active");
            $('#otherInformationTab').removeClass("active");
            $("#documentSelectionTabId").css("background-color", "rgb(18, 18, 19)");
            $("#otherInformation").css("background-color", "#120f65");
        });
    }


    function showHideRejectRemarks() {
        $('#rejectReason').on('change', function () {
            var rejectReason = $(this).val();
            if (rejectReason == 4) { //if the selected value is Other show this div
                $('.rejectRemarksDiv').show();
                $('#rejectRemarksErrorMsg').text('');
            } else {
                $('.rejectRemarksDiv').hide();
            }
        });
    }

    function removeErrorMsg() {
        $('#rejectReason').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#rejectReason').removeClass('error');
                $('#rejectReasonErrorMsg').text('');
            }
        });
        $('#rejectRemarks').on('keyup blur', function () {
            var value = $(this).val().trim();
            if (value != '') {
                $('#rejectRemarks').removeClass('error');
                $('#rejectRemarksErrorMsg').text('');
            }
        });
        $('#appoinmentDate').on('keyup blur', function () {
            var value = $(this).val().trim();
            if (value != '') {
                $('#appoinmentDate').removeClass('error');
                $('#appoinmentDateErrorMsg').text('');
            }
        });
    }

    function approveOrReject() {
        $('.btnSave').on('click', function () {
            var btnType = $(this).val();
            var applicationNo = $('#applicationNo').val();
            var remarks = $('#remarks').val();
            var rejectReasonId = $('#rejectReasons').val();
            var rejectRemarks = $('#rejectRemarks').val();
            $('#aaa').hide();
            $('#bbb').hide();

            var mobileNo = $('#mobileNo').val();

            if($('#appoinmentDate').val() == ""){
                var appoinmentDate = '01-Feb-1990';
            } else{
                var appoinmentDate = $('#appoinmentDate').val();
            }
            if($('#appoinmentTime').val() == ""){
                var appoinmentTime = '24:00';
            } else{
                var appoinmentTime = $('#appoinmentTime').val();
            }
            $('#btnReject').hide();
            $('#rejectReasons').val('');
            $('#rejectRemarks').val('');
            rejectReasonId = 0;
            rejectRemarks = null;
            if(appoinmentDate == ''){
                $('#appoinmentDate').addClass('error');
                $('#appoinmentDateErrorMsg').text('Appointment date is required');
                return;
            }
            if(appoinmentTime == ''){
                $('#appoinmentTime').addClass('error');
                $('#appoinmentTimeErrorMsg').text('Appointment time is required');
                return;
            }


            var url = _baseURL() + 'checkForAlreadyAssigned';
            $.ajax({
                url: url,
                type: 'GET',
                data: {
                    appoinmentDate: appoinmentDate,
                    appoinmentTime: appoinmentTime
                },
                success: function (res) {
                    var data = res.responseDTO;
                    if (res.responseStatus == 1) {
                        var url = _baseURL() + 'saveapproveDivorceMarriageCertificate';
                        $.ajax({
                            url: url,
                            type: 'POST',
                            data: {
                                applicationNo: applicationNo
                                , remarks: remarks
                                , rejectReasonId: rejectReasonId
                                , rejectRemarks: rejectRemarks
                                , appoinmentDate: appoinmentDate
                                , appoinmentTime: appoinmentTime
                                , mobileNo: mobileNo
                            },
                            success: function (res) {
                                if (res.responseStatus == 3) {//reject
                                    $('#registration').addClass('hidden');
                                    $('#approveAcknowledgement').removeClass('hidden');
                                    $('#serviceNameApprove').text(res.serviceName);
                                    $('#applicationNoApprove').text(res.applicationNumber);
                                    $('#appoinmentDateApprove').text(res.appoinmentDateApprove);
                                    $('#appoinmentTimeApprove').text(res.appoinmentTimeApprove);
                                    $('#courtName').text(res.courtName);
                                    $('.field').val('');
                                }  else {
                                    warningMsg(res.responseText);
                                }
                            }
                            , error: function (res) {
                                errorMsg(res.responseText)
                            }
                        });
                    } else {
                        warningMsg(res.responseText);
                        $('#appoinmentDate').val('');
                        $('#appoinmentTime').val('');
                        $('#appoinmentDate').addClass('error');
                        $('#appoinmentTime').addClass('error');
                    }
                }
            });
        });
    }

    /*function reject() {
     $('.btnSaves').on('click', function () {
     var btnType = $(this).val();
     var applicationNo = $('#applicationNo').val();
     var remarks = $('#remarks').val();
     var rejectReasonId = $('#rejectReason').val();
     var checkboxGroup=$("input:checkbox[name='reject_Reason']");
     checkboxGroup.prop('required',true);
     if(checkboxGroup.is(":checked")){
     $('#rejectReasonErrorMsg').text('');
     }else{
     $('#rejectReasonErrorMsg').text('Reject reason is required');
     return
     }
     // var rejectRemarks = $('#rejectRemarks').val();
     //$('#rejectReason').val('');
     $('#btnApprove').hide();
     var mobileNo = $('#mobileNo').val();
     if ($('#appoinmentDate').val() == "") {
     var appoinmentDate = '';
     }
     if ($('#appoinmentTimes').val() == "") {
     var appoinmentTimes = '';
     }
     var chkd = $('input:checkbox:checked');
     var vals = chkd.map(function() {
     return this.value;
     }).get().join(', ');
     rejectReasonId=vals;
     *//*if (rejectReasonId == null || rejectReasonId == 0) {
     $('#rejectReason').addClass('error');
     $('#rejectReasonErrorMsg').text('Reject reason is required');
     return;
     }*//*

     *//*if (rejectReasonId == 4 && rejectRemarks == '') {
     $('#rejectRemarks').addClass('error');
     $('#rejectRemarksErrorMsg').text('Reject remarks is required');
     return;
     }*//*
     var url = _baseURL() + 'saveapproveDivorceMarriageCertificates?applicationNo='+applicationNo+'&remarks='+remarks+'&rejectedId='+rejectReasonId+'&mobileNo='+mobileNo;
     $.ajax({
     url: url,
     type: 'POST',
     success: function (res) {
     if (res.responseStatus == 4) {//approve
     $('#registration').addClass('hidden');
     $('#rejectAcknowledgement').removeClass('hidden');
     $('#serviceNameReject').text(res.serviceName);
     $('#applicationNoReject').text(res.applicationNumber);
     $('#rejectReasonReject').text(res.rejectReason);
     $('.field').val('');
     } else {
     warningMsg(res.responseText);
     }
     }
     , error: function (res) {
     errorMsg(res.responseText)
     }
     });
     });
     }*/
    /*  function reject(){
     $('.btnSaves').on('click', function () {
     var btnType = $(this).val();
     var applicationNo = $('#applicationNo').val();
     var rejectReasonId = $('#rejectReasons').val();
     var rejectRemarks = rejectReasonId;
     var mobileNo = $('#mobileNo').val();
     var remarks=$('#remarks').val();
     $('#btnApprove').hide();
     if ($('#appoinmentDate').val() == "") {
     var appoinmentDate = '';
     }
     if ($('#appoinmentTimes').val() == "") {
     var appoinmentTimes = '';
     }
     if (rejectReasonId == 0) {
     $('#rejectReasons').addClass('error');
     $('#rejectReasonErrorMsg').text('Reject reason is required');
     return;
     }
     *//*?applicationNo='+applicationNo+'&remarks='+remarks+'&rejectRemarks='+rejectRemarks+'&rejectedId='+rejectReasonId+'&mobileNo='+mobileNo*//*
     var url = _baseURL() + 'saveapproveDivorceMarriageCertificates';
     $.ajax({
     url: url,
     type: 'POST',
     success: function (res) {
     if (res.responseStatus == 4) {//approve
     $('#registration').addClass('hidden');
     $('#rejectAcknowledgement').removeClass('hidden');
     $('#serviceNameReject').text(res.serviceName);
     $('#applicationNoReject').text(res.applicationNumber);
     $('#rejectReasonReject').text(res.rejectReason);
     $('.field').val('');
     } else {
     warningMsg(res.responseText);
     }
     }
     , error: function (res) {
     errorMsg(res.responseText)
     }
     });
     });
     }
     */

    function reject(){
        $('.btnSaves').on('click', function () {
            var btnType = $(this).val();
            var applicationNo = $('#applicationNo').val();
            var rejectReasons = $('#rejectReasons').val();
            var rejectRemarks = rejectReasons;
            var mobileNo = $('#mobileNo').val();
            var remarks=$('#remarks').val();
            $('#btnApprove').hide();
            if ($('#appoinmentDate').val() == "") {
                var appoinmentDate = '';
            }
            if ($('#appoinmentTimes').val() == "") {
                var appoinmentTimes = '';
            }
            if (rejectReasons == 0) {
                $('#rejectReasons').addClass('error');
                $('#rejectReasonErrorMsg').text('Reject reason is required');
            }else {
                var url = _baseURL() + 'saveapproveDivorceMarriageCertificates';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {
                        applicationNo: applicationNo
                        , remarks: remarks
                        , rejectReasons: rejectReasons
                        , rejectRemarks: rejectRemarks
                        , mobileNo: mobileNo
                    },
                    success: function (res) {
                        debugger;
                        if (res.responseStatus == 4) {//approve
                            $('#registration').addClass('hidden');
                            $('#rejectAcknowledgement').removeClass('hidden');
                            $('#serviceNameReject').text(res.serviceName);
                            $('#applicationNoReject').text(res.applicationNumber);
                            $('#rejectReasonReject').text(res.rejectOthers);
                            $('.field').val('');
                        } else {
                            warningMsg(res.responseText);
                        }
                    }
                    , error: function (res) {
                        errorMsg(res.responseText)
                    }
                });
            }
        });
    }

    function getAttachedFiles() {
        var url = _baseURL() + 'getAttachedFiles';
        var applicationNo = $('#applicationNo').val();
        $.ajax({
            url: url
            , type: 'GET'
            , data: {applicationNo: applicationNo}
            , success: function (res) {
                if (res.responseStatus == 1) {
                    var data = res.responseDTO;
                    var dataTableDefinition = [
                        {"data": "documentId", class: "documentId hidden"}
                        , {"data": "uploadUrl", class: "uploadUrl hidden"}
                        , {
                            "mRender": function (data, type, row, meta) {
                                return meta.row + 1;
                            }
                        }
                        , {"data": "documentName", class: "documentName"}
                        , /*{
                         "data": "", class: "btnView",
                         "defaultContent": "<button class='btn btn-sm btn-success btnView' type='button' id='btnView'><i class='fa fa-eye'>View</i></button>"
                         },*/ {
                            "data": "", class: "btnDownload",
                            "defaultContent": "<button class='btn btn-sm btn-success btnDownload' type='button' id='btnDownload'><i class='fa fa-download'>Download</i></button>"
                        }
                    ];
                    $('#attachmentDocumentTableId').DataTable({
                        data: data
                        , columns: dataTableDefinition
                        , destroy: true
                        , bSort: false
                        , search: false
                    });
                }
            }
        });
    }

    function downloadFile() {
        $('#attachmentDocumentTableId tbody').on('click', 'tr .btnDownload', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var documentId = selectedRow.find('.documentId').text();
            var uploadUrl = selectedRow.find('.uploadUrl').text();
            selectedRow.removeClass('selected');
            var url = _baseURL() + 'downloadFile/' + documentId;
            $.ajax({
                url: url,
                type: 'GET',
                data: {documentId: documentId},
                success: function () {
                    window.location.href = url;
                    //window.open(uploadUrl, '_blank');
                    //var w = window.open(url, '_blank');
                    //w.focus();
                }
            });
        });

        $('#attachmentDocumentTableId tbody').on('click', 'tr .btnView', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var documentId = selectedRow.find('.documentId').text();
            var uploadUrl = selectedRow.find('.uploadUrl').text();
            selectedRow.removeClass('selected');
            window.open(uploadUrl, '_blank');
        });
    }

    function downloadApplicationNo() {
        var doc = new jsPDF();
        var specialElementHandlers = {
            '#editor': function (element, renderer) {
                return true;
            }
        };
        $('#btnDownload').click(function () {
            doc.fromHTML($('#downloadAsPdf').html(), 15, 15, {
                'width': 170,
                'elementHandlers': specialElementHandlers
            });
            doc.save('Acknowledgement.pdf');
        });
    }

    function downloadApplicationNoReject() {
        var doc = new jsPDF();
        var specialElementHandlers = {
            '#editor': function (element, renderer) {
                return true;
            }
        };
        $('#btnDownloadReject').click(function () {
            doc.fromHTML($('#downloadAsPdfReject').html(), 15, 15, {
                'width': 170,
                'elementHandlers': specialElementHandlers
            });
            doc.save('Acknowledgement.pdf');
        });
    }
    return {
        disableTabs: disableTabs
        , getApplicationDetail: getApplicationDetail
        , downloadFile: downloadFile
        , getAttachedFiles: getAttachedFiles
        , btnNext: btnNext
        , btnPrevious: btnPrevious
        , showHideRejectRemarks: showHideRejectRemarks
        , removeErrorMsg: removeErrorMsg
        , approveOrReject: approveOrReject
        ,reject: reject
        , downloadApplicationNo: downloadApplicationNo
        , downloadApplicationNoReject: downloadApplicationNoReject
    }
})
();
$(document).ready(
    function () {
        approveDivorceMarriageCertificate.disableTabs();
        approveDivorceMarriageCertificate.getApplicationDetail();
        approveDivorceMarriageCertificate.downloadFile();
        approveDivorceMarriageCertificate.getAttachedFiles();
        approveDivorceMarriageCertificate.btnNext();
        approveDivorceMarriageCertificate.btnPrevious();
        approveDivorceMarriageCertificate.showHideRejectRemarks();
        approveDivorceMarriageCertificate.removeErrorMsg();
        approveDivorceMarriageCertificate.approveOrReject();
        approveDivorceMarriageCertificate.reject();
        approveDivorceMarriageCertificate.downloadApplicationNo();
        approveDivorceMarriageCertificate.downloadApplicationNoReject();
    });

