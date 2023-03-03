/**
 * Created by USER on 8/22/2019.
 */

printCertificate = (function () {

    "use strict";
    var form = $('#printCertificateFormId');
    var isSubmitted = false;

    function _baseURL() {
        return 'printCertificate/';
    }

    function removeErrorMsg() {
        $('#serviceId').on('change', function () {
            var serviceId = $(this).val();
            if (serviceId != '') {
                $('#serviceId').removeClass('error');
                $('#serviceIdErrorMsg').text('');
            }
        });
    }

    function validateReqFields() {
        var retval = true;
        if ($('#serviceId').val() == '') {
            $('#serviceIdErrorMsg').text('');
            $('#serviceId').addClass('error');
            $('#serviceIdErrorMsg').text('Please select service type');
            retval = false;
        }
        return retval;
    }

    function getCertificateList() {
        $('#btnGetDetail').on('click', function () {
            $('#printCertificateTableId').DataTable().destroy();
            $('#printCertificateTableId tbody').empty();
            var serviceId = $('#serviceId').val();
            if (!validateReqFields(serviceId)) {
                return false;
            }
            loadCertificate(serviceId, true);
        });
    }

    function loadCertificate(serviceId, isBtnGetDetails) {
        var url = _baseURL() + 'getCertificateList';
        $.ajax({
            url: url
            , type: 'GET'
            , data: {
                serviceId: serviceId
            }
            , success: function (res) {
                if (res.responseStatus == 1) {
                    var data = res.responseDTO;
                    $('#printCertificateTableIdDiv').removeClass('hidden');
                    var dataTableDefinition = [
                        {
                            class: "slNo"
                            , "mRender": function (data, type, row, meta) {
                                return meta.row + 1;
                            }
                        }
                        , {"data": "applicationNo", class: "applicationNo"}
                        , {"data": "fullName", class: "fullName"}
                        , {"data": "cidNo", class: "cidNo"}
                        , {"data": "mobileNo", class: "mobileNo"}
                        , {"data": "courtName", class: "courtName"}
                        , {
                            "data": "", class: "btnPrint",
                            "mRender": function () {
                                return "<a id='btnPrint' class='btn btn-info btn-sm'><i class='fa fa-print'></i>Print</a>";
                            }
                        }
                    ];
                    $('#printCertificateTableId').DataTable({
                        data: data
                        , columns: dataTableDefinition
                        , destroy: true
                        , bSort: false
                        , filter: true
                    });
                } else {
                    if (isBtnGetDetails) {
                        warningMsg(res.responseText);
                    }
                }
            }
        });
    }

    function btnPrint() {
        $('#printCertificateTableId tbody').on('click', 'tr #btnPrint', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var applicationNo = selectedRow.find('.applicationNo').text();
            var serviceId = applicationNo.substring(1,3);
            selectedRow.removeClass('selected');
            if(serviceId ==501){
                confirmMsg("Are you sure you want to print this certificate? Once you click YES this application will remove from the table.", function () {
                    print(applicationNo);
                });
            } else {
                confirmMsg("Are you sure you want to print this certificate? Once you click YES this application will remove from the table.", function () {
                    printPDF(applicationNo);
                });
            }
        });
    }

    function print(applicationNo) {
        window.open(_baseURL() + 'printCertificate?applicationNo=' + applicationNo);
    }

    function printPDF(applicationNo) {
        window.open(_baseURL() + 'printCertificateJasper?applicationNo=' + applicationNo);
    }


    /*function print(applicationNo) {
        var url = _baseURL() + 'printCertificate';
        if (isSubmitted) {
            errorMsg('Your request is processing. Please wait...');
            return;
        }
        isSubmitted = true;
        $('#btnSave').attr('disabled', true);
        $.ajax({
            url: url
            , type: 'GET'
            , data: {applicationNo: applicationNo}
            , success: function (res) {
                debugger;
                var data = res.responseDTO;
                var dataSpo = res.spouseDTO;
                var dataApp = res.applicantDTO;
                if (res.responseStatus == 1) {
                    populate(data);
                    populate(dataSpo);
                    populate(dataApp);
                    $('#judgementNoDzo').text(dataApp.judgementNoDzo);
                    $('#applicationIdDzo').text(dataApp.applicationIdDzo);
                    $('#printCertificateFrame').attr('src', bcseaGlobal.baseReportLocation() + res.responseDTO.reportName);
                    var timeTaken = setTimeout(function () {
                        $('#printCertificateFrame').get(0).contentWindow.print();
                    }, 1000);
                    loadCertificate($('#serviceId').val(), false);
                    successMsg(res.responseText);
                } else {
                    warningMsg(res.responseText);
                }
            }, complete: function () {
                isSubmitted = false;
                $('#btnSave').attr('disabled', false);
            }
        });
    }*/
    return {
          removeErrorMsg: removeErrorMsg
        , getCertificateList: getCertificateList
        , btnPrint: btnPrint
    }
})
();
$(document).ready(
    function () {
        $('.field').val('');
        printCertificate.removeErrorMsg();
        printCertificate.getCertificateList();
        printCertificate.btnPrint();
    });


