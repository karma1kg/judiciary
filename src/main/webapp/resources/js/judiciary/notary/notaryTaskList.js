/**
 * Created by USER on 8/2/2019.
 */
notaryTaskList = (function () {
    var form = $('#notaryTaskListFormId');

    function _baseURL() {
        return 'notaryTaskList/';
    }

    function getNotaryTaskList() {
        var service_id=$('#service_id').val();
        var url =_baseURL()+'getNotaryTaskList?serviceId='+service_id;
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
                        , {"data": "applicantName", class: "applicantName"}
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
                        , {
                            "data": "createdDate", class: "createdDate align-middle",
                            "mRender": function (data) {
                                return formatAsDate(data);
                            }
                        }
                    ];
                    $('#notaryTaskListTableId').DataTable({
                        data: data
                        , columns: dataTableDefinition
                        , destroy: true
                        , bSort: false
                    });
                }
            }
        });
    }

    function getClaimedTaskList() {
        var service_id=$('#service_id').val();
        //var url =_baseURL()+'getNotaryTaskList?serviceId='+service_id;
        var url = _baseURL() + 'getClaimedTaskList?serviceId='+service_id;
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
                        , {"data": "applicantName", class: "applicantName"}
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
                        , {
                            "data": "createdDate", class: "createdDate align-middle",
                            "mRender": function (data) {
                                return formatAsDate(data);
                            }
                        }
                    ];
                    $('#claimedNotaryTaskListTableId').DataTable({
                        data: data
                        , columns: dataTableDefinition
                        , destroy: true
                        , bSort: false
                    });
                }
            }
        });
    }

    function saveClaimTask() {
        $('#notaryTaskListTableId tbody').on('click', 'tr .applicationNo', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var applicationNo = selectedRow.find('.applicationNo').text();
            var serviceSlNo = selectedRow.find('.serviceSlNo').text();
            selectedRow.removeClass('selected');
            confirmMsg("Are you sure you want to claim application no " + applicationNo + "?", function () {
                var url = _baseURL() + 'saveClaimTask';
                var data = $(form).serializeArray();
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {applicationNo: applicationNo},
                    success: function (res) {
                        if (res.responseStatus == 1) {
                            getClaimedTaskList();
                            getNotaryTaskList();
                            $('#messageBox').removeClass('hidden');
                            $('#messageBox').html("Application is successfully claimed");
                           // successMsg(applicationNo + " claimed successfully.");
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

    function saveUnClaimTask() {
        $('#claimedNotaryTaskListTableId tbody').on('click', 'tr #unClaim', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var applicationNo = selectedRow.find('.applicationNo').text();
            var serviceSlNo = selectedRow.find('.serviceSlNo').text();
            selectedRow.removeClass('selected');
            confirmMsg("Are you sure you want to un claim application no " + applicationNo + "?", function () {
                var url = _baseURL() + 'saveUnClaimTask';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {applicationNo: applicationNo},
                    success: function (res) {
                        if (res.responseStatus == 1) {
                            getClaimedTaskList();
                            getNotaryTaskList();
                            $('#messageBox2').removeClass('hidden');
                            $('#messageBox2').html("Application is unclaimed successfully");
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

    function navigateToApplicationScreen() {
        $('#claimedNotaryTaskListTableId tbody').on('click', 'tr .applicationNo', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var applicationNo = selectedRow.find('.applicationNo').text();
            var serviceSlNo = selectedRow.find('.serviceSlNo').text();
            selectedRow.removeClass('selected');

            if (serviceSlNo == 501) {
                window.location.href = _baseURL() + 'navigateToApproveMarriageCertificate?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 502) {
                window.location.href = _baseURL() + 'navigateToApproveAuthenticationPersonalDetails?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 503) {
                window.location.href = _baseURL() + 'navigateToApproveAffirmationMarriageCertificate?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 504) {
                window.location.href = _baseURL() + 'navigateToApproveLostDocument?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 505) {
                window.location.href = _baseURL() + 'navigateToApproveSingleMaritalStatus?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 506) {
                window.location.href = _baseURL() + 'navigateToApproveChildTravelDocument?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 507) {
                window.location.href = _baseURL() + 'navigateToApproveAttestationDocument?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 508) {
                window.location.href = _baseURL() + 'navigateToApproveChildAdoption?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 509) {
                window.location.href = _baseURL() + 'navigateToApproveOrganTransplant?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 510) {
                window.location.href = _baseURL() + 'navigateToApproveClosingTransferAccounts?applicationNo=' + applicationNo
            }
            if (serviceSlNo == 511) {
                window.location.href = _baseURL() + 'navigateToApproveAttestAgreementWillsContract?applicationNo=' + applicationNo
            }

            if (serviceSlNo == 512) {
                window.location.href = _baseURL() + 'navigateToApproveNewMarriageCertificate?applicationNo=' + applicationNo
            }

            if (serviceSlNo == 513) {
                window.location.href = _baseURL() + 'navigateToApproveDivorceApplication?applicationNo=' + applicationNo
            }
        });
    }

    return {
          getNotaryTaskList: getNotaryTaskList
        , getClaimedTaskList: getClaimedTaskList
        , saveClaimTask: saveClaimTask
        , saveUnClaimTask: saveUnClaimTask
        , navigateToApplicationScreen: navigateToApplicationScreen
    }
})
();
$(document).ready(
    function () {
        notaryTaskList.getNotaryTaskList();
        notaryTaskList.getClaimedTaskList();
        notaryTaskList.saveClaimTask();
        notaryTaskList.saveUnClaimTask();
        notaryTaskList.navigateToApplicationScreen();
    });

