/**
 * Created by Sonam Tobgay on 4/1/2020.
 */
dataManagerTaskList = (function () {
    var form = $('#dataManagerTaskListFormId');

    function _baseURL() {
        return 'dataManagerTaskList/';
    }

    function getDataManagerTaskList() {
        var service_id=$('#service_id').val();
        var   url=_baseURL() + 'getDataManagerTaskList?serviceId='+service_id;
        $.ajax({
            url:url,
            type: 'GET',
            success: function (res) {
                if (res.responseStatus == 1) {
                    var data = res.responseDTO;
                    var dataTableDefinition = [
                        {"data": "serviceSlNo", class: "serviceSlNo hidden"}
                        , {
                            "mRender": function (data, type, row, meta) {
                                return meta.row + 1;
                            }
                        }
                        , {"data": "applicationNo", class: "applicationNo menu-link"}
                        , {"data": "serviceName", class: "serviceName"}
                        , {"data": "cidNo", class: "cidNo"}
                        , {"data": "mobileNo", class: "mobileNo"}
                        , {
                            "data": "statusId", class: "statusId",
                            "mRender": function (data) {
                                if (data == '1') {
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Submitted";
                                } else if (data == '2') {
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Claimed";
                                } else if (data == '3'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Verified";
                                }else if (data == '4'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Rejected";
                                }else if (data == '5'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Update and Printing";
                                }else if (data == '6'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Payment Cleared";
                                }else if (data == '7'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Claimed";
                                }else if (data == '8'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Printed Application";
                                }
                            }
                        }
                        , {"data": "statusName", class: "statusName"}
                        , {
                            "data": "createdDate", class: "createdDate align-middle",
                            "mRender": function (data) {
                                return formatAsDate(data);
                            }
                        }
                    ];
                    $('#dataManagerTaskListTableId').DataTable({
                        data: data
                        , columns: dataTableDefinition
                        , destroy: true
                        , bSort: false
                    });
                }
            }
        });
    }

    function getUpdateClaimedTaskList() {
        var service_id=$('#service_id').val();
        var url = _baseURL() + 'getUpdateClaimedTaskList?serviceId='+service_id;
        $.ajax({
            url: url,
            type: 'GET',
            success: function (res) {
                if (res.responseStatus == 1) {
                    var data = res.responseDTO;
                    var dataTableDefinition = [
                        {"data": "serviceSlNo", class: "serviceSlNo hidden"}
                        , {
                            "mRender": function (data, type, row, meta) {
                                return meta.row + 1;
                            }
                        }
                        , {
                            "data": "",
                            "mRender": function () {
                                return " <button class='btn btn-sm btn-danger' id='unClaim' type='button'><i class='fa fa-times'></i></button>";
                            }
                        }
                        , {"data": "applicationNo", class: "applicationNo menu-link"}
                        , {"data": "serviceName", class: "serviceName"}
                        , {"data": "cidNo", class: "cidNo"}
                        , {"data": "mobileNo", class: "mobileNo"}
                        , {
                            "data": "statusId", class: "statusId",
                            "mRender": function (data) {
                                if (data == '1') {
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Submitted";
                                } else if (data == '2') {
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Claimed";
                                } else if (data == '3'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Verified";
                                }else if (data == '4'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Rejected";
                                }else if (data == '5'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Update and Printing";
                                }else if (data == '6'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Payment Cleared";
                                }else if (data == '7'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Update Claimed";
                                }else if (data == '8'){
                                    return "<i class='status-icon bg-success'>" + "</i>" + "Printed Application";
                                }
                            }
                        }
                        , {"data": "statusName", class: "statusName"}
                        , {
                            "data": "createdDate", class: "createdDate align-middle",
                            "mRender": function (data) {
                                return formatAsDate(data);
                            }
                        }
                    ];
                    $('#claimedDataManagerTaskListTableId').DataTable({
                        data: data
                        , columns: dataTableDefinition
                        , destroy: true
                        , bSort: false
                    });
                }
            }
        });
    }

    function saveUpdateClaimTask() {
        $('#dataManagerTaskListTableId tbody').on('click', 'tr .applicationNo', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var applicationNo = selectedRow.find('.applicationNo').text();
            var serviceSlNo = selectedRow.find('.serviceSlNo').text();
            selectedRow.removeClass('selected');
            confirmMsg("Are you sure you want to claim application no " + applicationNo + "?", function () {
                var url = _baseURL() + 'saveUpdateClaimTask';
                var data = $(form).serializeArray();
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {applicationNo: applicationNo},
                    success: function (res) {
                        if (res.responseStatus == 1) {
                            getUpdateClaimedTaskList();
                            getDataManagerTaskList();
                            $('#messageBox').removeClass('hidden');
                            $('#messageBox').html("Application is successfully claimed");
                            /*successMsg(applicationNo + " claimed successfully.");*/
                            /*setTimeout(function() {
                             $('#messageBox').html(applicationNo + "Application is successfully claimed");
                             }, 3000);*/
                        } else {
                            errorMsg(res.responseText);
                        }
                    }, error: function (res) {
                        errorMsg(res.responseText);
                    }
                });
            });
        });
    }

    function saveUpdateUnClaimTask() {
        $('#claimedDataManagerTaskListTableId tbody').on('click', 'tr #unClaim', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var applicationNo = selectedRow.find('.applicationNo').text();
            var serviceSlNo = selectedRow.find('.serviceSlNo').text();
            selectedRow.removeClass('selected');
            confirmMsg("Are you sure you want to un claim application no " + applicationNo + "?", function () {
                var url = _baseURL() + 'saveUpdateUnClaimTask';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {applicationNo: applicationNo},
                    success: function (res) {
                        if (res.responseStatus == 1) {
                            getUpdateClaimedTaskList();
                            getDataManagerTaskList();
                            $('#messageBox2').removeClass('hidden');
                            $('#messageBox2').html("Application unclaimed successfully");
                            //successMsg(applicationNo + " un claimed successfully.");
                        } else {
                            errorMsg(res.responseText);
                        }
                    }, error: function (res) {
                        errorMsg(res.responseText);
                    }
                });
            });
        });
    }

    function navigateToUpdateApplicationScreen() {
        $('#claimedDataManagerTaskListTableId tbody').on('click', 'tr .applicationNo', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var applicationNo = selectedRow.find('.applicationNo').text();
            var serviceSlNo = selectedRow.find('.serviceSlNo').text();
            selectedRow.removeClass('selected');

            if (serviceSlNo == 501) {
                window.location.href = _baseURL() + 'navigateToUpdateMarriageCertificate?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 502) {
                window.location.href = _baseURL() + 'navigateToUpdateAuthenticationPersonalDetails?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 503) {
                window.location.href = _baseURL() + 'navigateToUpdateAffirmationMarriageCertificate?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 504) {
                window.location.href = _baseURL() + 'navigateToUpdateLostDocument?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 505) {
                window.location.href = _baseURL() + 'navigateToUpdateSingleMaritalStatus?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 506) {
                window.location.href = _baseURL() + 'navigateToUpdateChildTravelDocument?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 507) {
                window.location.href = _baseURL() + 'navigateToUpdateAttestationDocument?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 508) {
                window.location.href = _baseURL() + 'navigateToUpdateChildAdoption?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 509) {
                window.location.href = _baseURL() + 'navigateToUpdateOrganTransplant?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 510) {
                window.location.href = _baseURL() + 'navigateToUpdateClosingTransferAccounts?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 511) {
                window.location.href = _baseURL() + 'navigateToUpdateAttestAgreementWillsContract?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 512) {
                window.location.href = _baseURL() + 'navigateToUpdateNewMarriageCertificate?applicationNo=' + applicationNo
            }

            if (serviceSlNo == 513) {
                window.location.href = _baseURL() + 'navigateToUpdateDivorceApplication?applicationNo=' + applicationNo
            }

        });
    }

    return {
        getDataManagerTaskList: getDataManagerTaskList
        , getUpdateClaimedTaskList: getUpdateClaimedTaskList
        , saveUpdateClaimTask: saveUpdateClaimTask
        , saveUpdateUnClaimTask: saveUpdateUnClaimTask
        , navigateToUpdateApplicationScreen: navigateToUpdateApplicationScreen
    }
})
();
$(document).ready(
    function () {
        dataManagerTaskList.getDataManagerTaskList();
        dataManagerTaskList.getUpdateClaimedTaskList();
        dataManagerTaskList.saveUpdateClaimTask();
        dataManagerTaskList.saveUpdateUnClaimTask();
        dataManagerTaskList.navigateToUpdateApplicationScreen();
    });

